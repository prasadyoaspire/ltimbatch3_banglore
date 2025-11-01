import { useState, useEffect } from "react";

import AdminDashboard from "./AdminDashboard";
import UserDashboard from "./UserDashboard";


function Dashboard() {

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

    if (user.role === 'ADMIN') {
        return <AdminDashboard userId = {user.userId}/>
    }

    if (user.role === 'USER') {
        return <UserDashboard userId = {user.userId}/>
    }
}

export default Dashboard;