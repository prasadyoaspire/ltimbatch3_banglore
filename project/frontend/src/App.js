import './App.css';

import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Registration from './components/Registration';
import Login from './components/Login';
import Home from './components/Home';
import Navbar from './components/Navbar';
import { UserProvider } from './context/UserContext';
import AddProduct from './components/AddProduct';
import AdminDashboard from './components/AdminDashboard';
import UserDashboard from './components/UserDashboard';

function App() {
  return (
    <UserProvider>
      <Router>
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/register" element={<Registration />} />
          <Route path="/login" element={<Login />} />
          <Route path="/admin/dashboard" element={<AdminDashboard />} />
           <Route path="/user/dashboard" element={<UserDashboard />} />
          <Route path="/product/add" element={<AddProduct />} />
        </Routes>
      </Router>
    </UserProvider>
  );
}

export default App;
