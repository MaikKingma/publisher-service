package nl.codecentric.publisher_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Maik Kingma
 */

@Slf4j
@RestController
@RequestMapping("/publishers/receiveBookOffer")
public class PublisherCommand {

    private final PublisherService publisherService;

    public PublisherCommand(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    IsbnDTO receiveBookOffer(@RequestBody BookOffer bookOffer) throws PublisherService.PublisherNotFoundException {
        publisherService.getPublisherById(bookOffer.getPublisherId());
        return new IsbnDTO("ISBN-" + UUID.randomUUID());
    }

    private record IsbnDTO(String isbn) {
    }
}
