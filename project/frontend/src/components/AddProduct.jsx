import { useState } from "react";
import { saveProduct } from "../service/productService";
import { useNavigate } from "react-router-dom";

const AddProduct = () => {
    const [product, setProduct] = useState({
        productName: "",
        price: "",
        description: "",
        category: "",
        origin: "",
        quantity: "",
        coverImage: "",
    });

    const [message, setMessage] = useState("");
    const [loading, setLoading] = useState(false);

    const navigate = useNavigate();
    const userId = JSON.parse(localStorage.getItem('user'))?.userId;

    const handleChange = (e) => {
        setProduct({
            ...product,
            [e.target.name]: e.target.value,
        });
    };

    const handleFileChange = (e) => {
        const file = e.target.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onloadend = () => {
                setProduct({ ...product, coverImage: reader.result });
            };
            reader.readAsDataURL(file);
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setLoading(true);
        setMessage("");

        console.log("userId: "+userId);
        try {
            await saveProduct(userId, product);

            setMessage("Product saved successfully!");
            setProduct({
                productName: "",
                price: "",
                description: "",
                category: "",
                origin: "",
                quantity: "",
                coverImage: "",
            });

            setTimeout(() => navigate("/dashboard"), 1500);
        } catch (error) {
            console.error(error);
            setMessage("Failed to save product. Please try again.");
        } finally {
            setLoading(false);
        }
    };

    return (
        <div>
            <h2>Create New Product</h2>
            {message && <p>{message}</p>}

            <form onSubmit={handleSubmit}>
                <div>
                    <label>Product Name:</label>
                    <input
                        type="text"
                        name="productName"
                        value={product.productName}
                        onChange={handleChange}
                    />
                </div>

                <div>
                    <label>Price:</label>
                    <input
                        type="number"
                        name="price"
                        value={product.price}
                        onChange={handleChange}
                    />
                </div>

                <div>
                    <label>Description:</label>
                    <textarea
                        name="description"
                        value={product.description}
                        onChange={handleChange}
                    />
                </div>

                <div>
                    <label>Category:</label>
                    <input
                        type="text"
                        name="category"
                        value={product.category}
                        onChange={handleChange}
                    />
                </div>

                <div>
                    <label>Origin:</label>
                    <input
                        type="text"
                        name="origin"
                        value={product.origin}
                        onChange={handleChange}
                    />
                </div>

                <div>
                    <label>Quantity:</label>
                    <input
                        type="number"
                        name="quantity"
                        value={product.quantity}
                        onChange={handleChange}
                    />
                </div>

                <div>
                    <label>Cover Image:</label>
                    <input type="file" accept="image/*" onChange={handleFileChange} />
                </div>

                <button
                    type="submit"
                    style={{ marginTop: "10px" }}
                    disabled={loading}
                >
                    {loading ? "Saving..." : "Save Product"}
                </button>
            </form>
        </div>
    );
};

export default AddProduct;