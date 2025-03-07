package uz.challengeapp;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeService {

    private final ChallengeRepository challengeRepository;

    public ChallengeService(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    public Challenge getChallenge(Long id) {
        return challengeRepository.findById(id).orElse(null);
    }

    public Challenge getChallengeByMonth(String month) {
        return challengeRepository.findByMonthEqualsIgnoreCase(month);
    }

    public boolean addChallenge(Challenge challenge) {
        challengeRepository.save(challenge);
        return true;
    }

    public boolean updateChallenge(Long id, Challenge challenge) {
        Challenge challenge1 = getChallenge(id);
        if (challenge1 != null) {
            if (challenge.getMonth()!=null) {
                challenge1.setMonth(challenge.getMonth());
            }
            if (challenge.getDescription()!=null) {
                challenge1.setDescription(challenge.getDescription());
            }
            challengeRepository.save(challenge1);
            return true;
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        return challengeRepository.deleteChallengeById(id);
    }
}
