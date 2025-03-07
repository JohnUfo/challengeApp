import "./Challenge.css";

function Challenge({ challenge, onEdit, onDelete }) {
  return (
    <div className="challenge">
      <h3>{challenge.month}</h3>
      <p>{challenge.description}</p>
      <button onClick={onEdit}>Edit</button>
      <button onClick={onDelete}>Delete</button>
    </div>
  );
}

export default Challenge;