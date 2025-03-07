package uz.challengeapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {

    private List<Challenge> challenges = new ArrayList<>();


    public List<Challenge> getAllChallenges() {
        return challenges;
    }

    public Challenge getChallenge(Long id) {
        return challenges.stream().filter(challenge -> challenge.getId().equals(id)).findFirst().orElse(null);
    }

    public Challenge getChallengeByMonth(String month) {
        for (Challenge challenge : challenges) {
            if (challenge.getMonth().equalsIgnoreCase(month)) {
                return challenge;
            }
        }
        return null;
    }

    public boolean addChallenge(Challenge challenge) {
        return challenges.add(challenge);
    }

    public boolean updateChallenge(Long id, Challenge challenge) {
        for (Challenge challenge1 : challenges) {
            if (challenge1.getId().equals(id)) {
                challenge1.setMonth(challenge.getMonth());
                challenge1.setDescription(challenge.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        return challenges.removeIf(challenge -> challenge.getId().equals(id));
    }
}
