package repositories;

import models.URLMapping;

import java.util.List;
import java.util.Optional;

public interface URLRepository {
    void save(URLMapping urlMapping);
    Optional<URLMapping> getByShortKey(String shortKey);
    void deleteExpiredUrls();
    List<URLMapping> getAllUrls();
}
