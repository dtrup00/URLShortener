package services;

import models.URLMapping;
import repositories.URLRepository;
import utils.ShortKeyGenerator;

import java.util.*;

public class URLService {
    private final URLRepository urlRepository;

    public URLService(URLRepository repository) {
        this.urlRepository = repository;
    }

    public String shortenURL(String longURL) {
        String shortkey = ShortKeyGenerator.generateKey();
        URLMapping urlMapping = new URLMapping(shortkey, longURL);

        urlRepository.save(urlMapping);
        return shortkey;
    }

    public void displayAllUrls() {
        List<URLMapping> urls = urlRepository.getAllUrls();

        if(urls.isEmpty()) {
            System.out.print("No URLs found");
            return;
        } else {
            System.out.println("\n Stored URLs");
            for(URLMapping url: urls) {
                System.out.printf("Short URL: %s, Original URL: %s, Accessed %s times",
                        url.getShortKey(), url.getLongUrl(), url.getAccessCount());
            }
        }
    }
}
