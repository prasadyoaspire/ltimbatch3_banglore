import { useState, useContext } from 'react';
import { login } from '../service/userService';
import { Link, useNavigate } from 'react-router-dom';
import { UserContext } from '../context/UserContext';

function Login() {
    const [formData, setFormData] = useState({
        email: '',
        password: ''
    });

    const [message, setMessage] = useState('');
    const [errors, setErrors] = useState({});
    const [isLoading, setIsLoading] = useState(false);

    const navigate = useNavigate();
    const { loginUser } = useContext(UserContext);

    const validate = () => {
        const newErrors = {};

        if (!formData.email.trim()) {
            newErrors.email = 'Email is required';
        }
        if (!formData.password.trim()) {
            newErrors.password = 'Password is required';
        }

        setErrors(newErrors);
        return Object.keys(newErrors).length === 0;
    };

    const handleChange = (e) => {
        e.preventDefault();
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
        setErrors({
            ...errors,
            [e.target.name]: ''
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (!validate()) {
            return;
        }

        setIsLoading(true);
        setMessage('');

        try {
            const data = await login(formData);
            setFormData({ email: '', password: '' });

            const userData = {
                userId: data.userId,
                name: `${data.firstName} ${data.lastName}`,
                role: data.role,
                email: formData.email
            };

            loginUser(userData);

            if (data.role === 'ADMIN') {
                navigate('/admin/dashboard');
            } else if (data.role === 'USER') {
                navigate('/user/dashboard');
            } else {
                navigate('/');
            }
        } catch (error) {
            setMessage(error.message);
        } finally {
            setIsLoading(false);
        }
    };

    return (
        <div style={{ width: '350px', margin: 'auto' }}>
            <h2>Login</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <input
                        type="email"
                        name="email"
                        placeholder="Email"
                        value={formData.email}
                        onChange={handleChange}
                    />
                    {errors.email && <p style={{ color: 'red' }}>{errors.email}</p>}
                </div>

                <div>
                    <input
                        type="password"
                        name="password"
                        placeholder="Password"
                        value={formData.password}
                        onChange={handleChange}
                    />
                    {errors.password && <p style={{ color: 'red' }}>{errors.password}</p>}
                </div>

                <button type="submit" disabled={isLoading}>
                    {isLoading ? 'Logging in...' : 'Login'}
                </button>
            </form>
            <p style={{ color: 'red' }}>{message}</p>
            <p style={{ color: 'blue' }}>Don't have an Account? <Link to="/register">Signup</Link></p>
        </div>
    );
}

export default Login;
