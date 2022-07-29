package nl.codecentric.publisher_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author Maik Kingma
 */

@RestController
@RequestMapping(value = "/publishers")
public class PublisherQuery {

    private final PublisherService publisherService;

    public PublisherQuery(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public List<Publisher> findAll() {
        return publisherService.getAllPublishers();
    }

    @GetMapping("/{id}")
    public Publisher findAll(@PathVariable("id") UUID uuid) throws PublisherService.PublisherNotFoundException {
        return publisherService.getPublisherById(uuid);
    }
}
