package uz.challengeapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Challenge {
    private Long id;
    private String month;
    private String description;
}
