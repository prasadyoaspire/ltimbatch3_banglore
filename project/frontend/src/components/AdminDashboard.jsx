import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import UserProducts from "./UserProducts";

function AdminDashboard() {
    const [user, setUser] = useState(null);

    useEffect(() => {
        const storedUser = localStorage.getItem('user');
        if (storedUser) {
            console.log(storedUser);
            setUser(JSON.parse(storedUser));
        }
    }, []);

    if (!user) {
        return <p>Loading user...</p>;
    }
    return (
        <>

            <div style={{ display: "flex", justifyContent: "flex-end" , margin:"50px 20px"}}>
                <Link to="/product/add">
                    <button>Add New Product</button>
                </Link>
            </div>

            <div>
                <UserProducts />
            </div>
        </>
    )
}

export default AdminDashboard;