import React from 'react';
import { Link } from 'react-router-dom';

const Navbar = () => {
  return (
    <nav className="bg-gray-800 p-4 text-white">
      <ul className="flex space-x-4">
        <li><Link to="/">Dashboard</Link></li>
        <li><Link to="/add-stock">Add Stock</Link></li>
      </ul>
    </nav>
  );
};

export default Navbar;
