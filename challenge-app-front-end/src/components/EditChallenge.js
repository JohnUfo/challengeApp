import { useState } from "react";
import "./EditChallenge.css";

function EditChallenge({ challenge, onUpdate, onCancel }) {
  const [month, setMonth] = useState(challenge.month);
  const [description, setDescription] = useState(challenge.description);

  const handleSubmit = (e) => {
    e.preventDefault();
    onUpdate({ ...challenge, month, description });
  };

  return (
    <form className="edit-challenge" onSubmit={handleSubmit}>
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
      <button type="submit">Save</button>
      <button type="button" onClick={onCancel}>
        Cancel
      </button>
    </form>
  );
}

export default EditChallenge;