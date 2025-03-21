package services;

import models.URLMapping;
import repositories.URLRepository;
import utils.ShortKeyGenerator;

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
}
