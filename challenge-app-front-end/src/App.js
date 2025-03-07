import { useEffect, useState } from "react";
import "./App.css";
import ChallengeList from "./components/ChallengeList";
import axios from "axios";
import AddChallenge from "./components/AddChallenge";

function App() {
  const [challenges, setChallenges] = useState([]);

  const fetchChallenges = async () => {
    try {
      const response = await axios.get("http://localhost:8080/challenges");
      setChallenges(response.data);
    } catch (error) {
      console.error("Error fetching challenges:", error);
    }
  };

  useEffect(() => {
    fetchChallenges();
  }, []);

  const handleChallengeAdded = () => {
    fetchChallenges();
  };

  const handleChallengeUpdated = () => {
    fetchChallenges(); 
  };

  const handleChallengeDeleted = (id) => {
    setChallenges(challenges.filter((challenge) => challenge.id !== id));
  };

  return (
    <div className="App">
      <h1>Monthly Challenges</h1>
      <AddChallenge onChallengeAdded={handleChallengeAdded} />
      <ChallengeList
        challenges={challenges}
        onChallengeUpdated={handleChallengeUpdated}
        onChallengeDeleted={handleChallengeDeleted}
      />
    </div>
  );
}

export default App;