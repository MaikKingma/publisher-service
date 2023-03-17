package eu.javaland.publisher_service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Maik Kingma
 */

@Service
public class PublisherService {

    private final List<Publisher> publishers = List.of(
            new Publisher(UUID.fromString("80553AE1-2EF8-4ADF-8FA8-D551684A9EA3"), "the/experts.", "VAT12345", 30, 99, 200),
            new Publisher(UUID.fromString("01A49A75-E3C7-4C8B-B039-D1DF2BFB7ED7"), "Heise", "VAT32723", 3333, 432, 4532),
            new Publisher(UUID.fromString("C58EEDED-6568-4D27-BBA7-4C1E440E9E46"), "PubIT", "VAT4242111", 56, 21, 2),
            new Publisher(UUID.fromString("63E3148F-8C1A-4F53-9151-A1F8A82B9FB5"), "AwesomeBooks.eu", "n/a", 1, -1, 3)
    );

    public List<Publisher> getAllPublishers() {
        return publishers;
    }

    public Publisher getPublisherById(UUID publisherId) throws PublisherNotFoundException {
        List<Publisher> publishers =
                this.publishers.stream().filter(publisher -> publisher.getId().equals(publisherId)).collect(Collectors.toList());
        if (publishers.isEmpty()) {
            throw new PublisherNotFoundException();
        }
        return publishers.get(0);
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Publisher Not Found")
    public static class PublisherNotFoundException extends Exception {
        public PublisherNotFoundException() {
        }
    }
}
