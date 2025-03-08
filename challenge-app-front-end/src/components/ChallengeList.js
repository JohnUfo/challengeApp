import Challenge from "./Challenge";
import EditChallenge from "./EditChallenge";
import axios from "axios";
import {useState} from "react";

function ChallengeList({ challenges, onChallengeUpdated, onChallengeDeleted }) {
  const safeChallenges = Array.isArray(challenges) ? challenges : [];
  const [editingChallenge, setEditingChallenge] = useState(null);

  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/challenges/${id}`);
      onChallengeDeleted(id);
    } catch (error) {
      console.error("Error deleting challenge:", error);
    }
  };

  const handleUpdate = async (updatedChallenge) => {
    try {
      await axios.put(`http://localhost:8080/challenges/${updatedChallenge.id}`, updatedChallenge);
      setEditingChallenge(null);
      onChallengeUpdated(); // Refresh the list of challenges
    } catch (error) {
      console.error("Error updating challenge:", error);
    }
  };

  return (
      <div className="challenge-list">
        <h2>Challenges</h2>
        {safeChallenges.map((challenge) => (
            <div key={challenge.id}>
              {editingChallenge === challenge.id ? (
                  <EditChallenge
                      challenge={challenge}
                      onUpdate={handleUpdate}
                      onCancel={() => setEditingChallenge(null)}
                  />
              ) : (
                  <Challenge
                      challenge={challenge}
                      onEdit={() => setEditingChallenge(challenge.id)}
                      onDelete={() => handleDelete(challenge.id)}
                  />
              )}
            </div>
        ))}
      </div>
  );
}

export default ChallengeList;