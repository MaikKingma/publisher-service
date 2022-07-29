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
public class BookOffer {
    private String authorName;
    private String title;
    private UUID publisherId;
}
