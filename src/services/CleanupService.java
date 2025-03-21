package services;

import repositories.URLRepository;

public class CleanupService {
    private final URLRepository urlRepository;

    public CleanupService(URLRepository repository) {
        this.urlRepository = repository;
    }

    public void cleanupExpiredUrls() {
        urlRepository.deleteExpiredUrls();
    }
}
