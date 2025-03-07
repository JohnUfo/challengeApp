package uz.challengeapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
@CrossOrigin(origins = "*")
public class ChallengeController {

    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public ResponseEntity<List<Challenge>> getChallenges() {
        List<Challenge> challenges = challengeService.getAllChallenges();
        return challenges.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(challenges);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable Long id) {
        Challenge challenge = challengeService.getChallenge(id);
        return (challenge != null) ? ResponseEntity.ok(challenge) : ResponseEntity.notFound().build();
    }

    @GetMapping("/by-month/{month}")
    public ResponseEntity<Challenge> getChallengesByMonth(@PathVariable String month) {
        Challenge challenge = challengeService.getChallengeByMonth(month);
        return (challenge != null) ? ResponseEntity.ok(challenge) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge) {
        boolean isAdded = challengeService.addChallenge(challenge);
        return isAdded
                ? ResponseEntity.status(201).body("Challenge added successfully")
                : ResponseEntity.badRequest().body("Challenge could not be added");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge challenge) {
        boolean updatedChallenge = challengeService.updateChallenge(id, challenge);
        if (updatedChallenge) {
            return new ResponseEntity<>("Challenge updated successfully", HttpStatus.OK);
        }else
            return new ResponseEntity<>("Challenge could not be updated", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChallenge(@PathVariable("id") Long id) {
        boolean isDeleted = challengeService.deleteChallenge(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
