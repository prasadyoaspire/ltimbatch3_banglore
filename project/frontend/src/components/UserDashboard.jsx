import { useState, useEffect } from "react";

function UserDashboard() {

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
            <h2>User Dashboard</h2>
        </>
    )
}

export default UserDashboard;