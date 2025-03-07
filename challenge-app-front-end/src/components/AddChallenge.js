import { useState } from "react";
import axios from "axios";
import "./AddChallenge.css";

function AddChallenge({ onChallengeAdded }) {
  const [month, setMonth] = useState("");
  const [description, setDescription] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    const newChallenge = {
      month,
      description,
    };

    try {
      const response = await axios.post("http://localhost:8080/challenges", newChallenge);
      console.log("Challenge added:", response.data);

      setMonth("");
      setDescription("");

      if (onChallengeAdded) {
        onChallengeAdded(); 
      }
    } catch (error) {
      console.error("Error adding challenge:", error);
    }
  };

  return (
    <div className="add-challenge">
      <h2>Add New Challenge</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="month">Month</label>
          <input
            type="text"
            id="month"
            value={month}
            onChange={(e) => setMonth(e.target.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="description">Description</label>
          <textarea
            id="description"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            required
          />
        </div>
        <button type="submit">Add Challenge</button>
      </form>
    </div>
  );
}

export default AddChallenge;