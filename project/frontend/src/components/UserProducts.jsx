import React, { useState, useEffect } from "react";
import ProductList from "./ProductList";
import { getProductsByUser, deleteProduct } from "../service/productService";
import { useNavigate } from "react-router-dom";

const UserProducts = () => {
    const [products, setProducts] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");
    const navigate = useNavigate();

    const user = JSON.parse(localStorage.getItem("user"));
    const userId = user?.userId;

    useEffect(() => {
        const fetchProducts = async () => {
            if (!userId) {
                setError("User not logged in");
                setLoading(false);
                return;
            }

            try {
                const data = await getProductsByUser(userId);
                setProducts(data);
            } catch {
                setError("Failed to fetch products");
            } finally {
                setLoading(false);
            }
        };

        fetchProducts();
    }, [userId]);

    const handleView = (product) => {
        // Navigate to product view page or show modal
        navigate(`/product/view/${product.productId}`);
    };

    const handleEdit = (product) => {
        // Navigate to edit page
        navigate(`/product/edit/${product.productId}`, { state: { product } });
    };

    const handleDelete = async (product) => {
        if (window.confirm(`Are you sure you want to delete "${product.productName}"?`)) {
            try {
                await deleteProduct(product.productId);
                setProducts(products.filter(p => p.productId !== product.productId));
            } catch {
                alert("Failed to delete product.");
            }
        }
    };

    if (loading) return <p>Loading products...</p>;
    if (error) return <p style={{ color: "red" }}>{error}</p>;

    return (
        <div>
            <h2>My Products</h2>
            <ProductList
                products={products}
                onView={handleView}
                onEdit={handleEdit}
                onDelete={handleDelete}
            />
        </div>
    );
};

export default UserProducts;
