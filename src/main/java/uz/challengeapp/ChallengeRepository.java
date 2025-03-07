package uz.challengeapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    Challenge findByMonthEqualsIgnoreCase(String month);

    boolean deleteChallengeById(Long id);
}
