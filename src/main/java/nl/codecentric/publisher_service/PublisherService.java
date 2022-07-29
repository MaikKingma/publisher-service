package nl.codecentric.publisher_service;

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
            new Publisher(UUID.randomUUID(), "Codecentric", "VAT12345", 30, 99, 200),
            new Publisher(UUID.randomUUID(), "Heise", "VAT32723", 3333, 432, 4532),
            new Publisher(UUID.randomUUID(), "PubIT", "VAT4242111", 56, 21, 2),
            new Publisher(UUID.randomUUID(), "AwesomeBooks.nl", "n/a", 1, -1, 3)
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
