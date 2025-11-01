import React from "react";
import './ProductList.css';

const ProductList = ({ products, onView, onEdit, onDelete }) => {
    return (
        <div className="product-grid">
            {products.map((product) => (
                <div className="product-card" key={product.productId}>
                    <img
                        src={`http://localhost:8081/uploads/${product.coverImage}`}
                        alt={product.productName}
                        className="product-image"
                    />
                    <h3 className="product-title">{product.productName}</h3>
                    <p className="product-price">Price: ${product.price}</p>
                    <p className="product-description">{product.description}</p>

                    <div className="button-row">
                        <button className="btn btn-view" onClick={() => onView(product)}>View</button>
                        <button className="btn btn-edit" onClick={() => onEdit(product)}>Edit</button>
                        <button className="btn btn-delete" onClick={() => onDelete(product)}>Delete</button>
                    </div>
                </div>
            ))}
        </div>
    );
};

export default ProductList;