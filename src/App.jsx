// App.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './App.css'; // Import CSS file for styling

const App = () => {
  const [data, setData] = useState([]);
  const [name, setName] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');
  const [location, setLocation] = useState('');
  const [email, setEmail] = useState('');
  const [responseMessage, setResponseMessage] = useState('');

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/Resp');
      setData(response.data);
    } catch (error) {
      console.error('Error:', error);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/api/Resp', {
        name,
        phoneNumber,
        location,
        email,
      });
      setResponseMessage(response.data.message);
      fetchData(); // Fetch updated data after submission
    } catch (error) {
      console.error('Error:', error);
    }
  };

  return (
    <div className="container"> {/* Apply container class */}
      <h1>Input Form</h1>
      <form onSubmit={handleSubmit}>
        <div className='text'>
        <label>Name:</label>
        <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
        <label>Phone Number:</label>
        <input type="text" value={phoneNumber} onChange={(e) => setPhoneNumber(e.target.value)} />
        <label>Location:</label>
        <input type="text" value={location} onChange={(e) => setLocation(e.target.value)} />
        <label>Email:</label>
        <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
        <button type="submit">Submit</button>
        </div>
      </form>
      {responseMessage && (
        <div className="response"> {/* Apply response class */}
          <h2>Response</h2>
          <p>{responseMessage}</p>
        </div>
      )}
      
    </div>
  );
};

export default App;