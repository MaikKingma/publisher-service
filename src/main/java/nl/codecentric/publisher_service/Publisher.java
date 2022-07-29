package nl.codecentric.publisher_service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * @author Maik Kingma
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
    private UUID id;
    private String name;
    private String taxNumber;
    private Integer numberOfEmployees;
    private Integer yearlyRevenueInMillions;
    private Integer amountOfBooksPublished;
}
