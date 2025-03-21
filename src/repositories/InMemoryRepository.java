package repositories;

import models.URLMapping;

import java.time.LocalDateTime;
import java.util.*;

public class InMemoryRepository implements URLRepository {
    private final Map<String, URLMapping> storage = new HashMap<>();

    @Override
    public void save(URLMapping urlMapping) {

    }

    @Override
    public Optional<URLMapping> getByShortKey(String shortKey) {
        URLMapping urlMapping = storage.get(shortKey);
        if(urlMapping != null) {
            urlMapping.updateLastAccessed();
        }

        return Optional.ofNullable(urlMapping);
    }

    @Override
    public void deleteExpiredUrls() {
        storage.entrySet().removeIf(entry -> entry.getValue().getLastAccessedAt().isBefore(LocalDateTime.now().minusDays(30)));
    }
}
