import { useState } from 'react';
import { registerUser } from '../service/userService';
import { Link, useNavigate } from 'react-router-dom';

function Registration() {
    const [formData, setFormData] = useState({
        firstName: '',
        lastName: '',
        mobileNumber: '',
        email: '',
        role: '',
        password: '',
        confirmPassword: ''
    });

    const [message, setMessage] = useState('');
    const [formErrors, setFormErrors] = useState({});
    const navigate = useNavigate();

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const validateForm = () => {
        const errors = {};

        if (!formData.role) {
            errors.role = "Role is required";
        }
        if (!formData.firstName) {
            errors.firstName = "First Name is required";
        }
        if (!formData.lastName) {
            errors.lastName = "Last Name is required";
        }
        if (!formData.mobileNumber) {
            errors.mobileNumber = "Mobile Number is required";
        }
        else if (/^\d{10}$/.test(formData.mobileNumber)) {
            errors.mobileNumber = "Invalid mobile number";
        }
        if (!formData.email) {
            errors.email = "Email is required";
        }
        else if (!/^[^/s@]+@[^\s@]+\.[^\s@]+$/.test(formData.email)) {
            errors.email = "Invalid email";
        }
        if (!formData.password) {
            errors.password = "Password is required";
        }
        if (!formData.confirmPassword) {
            errors.confirmPassword = "Confirm Password is required";
        }
        if (formData.password !== formData.confirmPassword) {
            errors.confirmPassword = "Password and Confirm Password not matching";
        }

        setFormErrors(errors);
        return Object.keys(errors).length === 0;
    }

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (validateForm()) {
            try {
                const data = await registerUser(formData);
                setMessage("User registered successfully!");
                setFormData({
                    firstName: '',
                    lastName: '',
                    mobileNumber: '',
                    email: '',
                    role: 'USER',
                    password: '',
                    confirmPassword: ''
                });
                setTimeout(() => navigate("/"), 1500);
            } catch (error) {
                setMessage(`Error: ${error.message}`);
            }
        }
    };

    return (
        <div style={{ width: '550px', margin: 'auto' }}>
            <h2>Register</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Select Role:</label>
                    <select
                        name="role"
                        value={formData.role}
                        onChange={handleChange}
                    >
                        <option value="">--Role--</option>
                        <option value="USER">User</option>
                        <option value="ADMIN">Admin</option>
                    </select>
                    {formErrors.role && <p style={{ color: 'red' }}>{formErrors.role}</p>}
                </div>

                <div>
                    <label>First Name:</label>
                    <input
                        type="text"
                        name="firstName"
                        value={formData.firstName}
                        onChange={handleChange}
                    />
                    {formErrors.firstName && <p style={{ color: 'red' }}>{formErrors.firstName}</p>}
                </div>
                <div>
                    <label>Last Name:</label>
                    <input
                        type="text"
                        name="lastName"
                        value={formData.lastName}
                        onChange={handleChange}
                    />
                    {formErrors.lastName && <p style={{ color: 'red' }}>{formErrors.lastName}</p>}

                </div>
                <div>
                    <label>Mobile Number:</label>
                    <input
                        type="text"
                        name="mobileNumber"
                        value={formData.mobileNumber}
                        onChange={handleChange}
                    />
                    {formErrors.mobileNumber && <p style={{ color: 'red' }}>{formErrors.mobileNumber}</p>}

                </div>
                <div>
                    <label>E-mail Id:</label>
                    <input
                        type="email"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                    />
                    {formErrors.email && <p style={{ color: 'red' }}>{formErrors.email}</p>}

                </div>
                <div>
                    <label>Password:</label>
                    <input
                        type="password"
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                    />
                    {formErrors.password && <p style={{ color: 'red' }}>{formErrors.password}</p>}
                </div>
                <div>
                    <label>Confirm Password:</label>
                    <input
                        type="password"
                        name="confirmPassword"
                        value={formData.confirmPassword}
                        onChange={handleChange}
                    />
                    {formErrors.confirmPassword && <p style={{ color: 'red' }}>{formErrors.confirmPassword}</p>}

                </div>
                <button type="submit">Register</button>
            </form>

            <p>{message}</p>
            <p style={{ color: 'green' }}>Already have an Account? <Link to="/login">Login</Link></p>
        </div>
    );
}

export default Registration;
