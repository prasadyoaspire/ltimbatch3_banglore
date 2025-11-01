import { useContext } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { UserContext } from '../context/UserContext';

function Navbar() {
    const { user, logoutUser } = useContext(UserContext);
    const navigate = useNavigate();

    const handleLogout = () => {
        logoutUser();
        navigate('/login');
    };

    return (
        <div>    

            <div>
                {!user ? (
                    <>
                        <Link to="/register" style={{ marginRight: '10px' }}>
                            Register
                        </Link>
                        <Link to="/login">Login</Link>
                    </>
                ) : (
                    <>
                      <div style={{ display: "flex", justifyContent: "flex-end", margin:"50px 20px" }}>
                        <span style={{ fontWeight: 'bold', marginRight: '10px' }}>
                           Welcome, {user.name}
                        </span>
                        <button onClick={handleLogout}>Logout</button>
                        </div>
                    </>
                )}
            </div>
        </div>
    );
}

export default Navbar;
