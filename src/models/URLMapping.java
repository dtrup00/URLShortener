package models;

import java.time.LocalDateTime;

public class URLMapping {
    private String shortKey;
    private String longUrl;
    private LocalDateTime lastAccessedAt;
    private LocalDateTime createdAt;

    public URLMapping(String shortKey, String longUrl) {
        this.shortKey = shortKey;
        this.longUrl = longUrl;
        this.lastAccessedAt = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }

    public String getShortKey() { return this.shortKey; }
    public String getLongUrl() { return this.longUrl; }
    public LocalDateTime getLastAccessedAt() { return this.lastAccessedAt; }

    public void updateLastAccessed() {
        this.lastAccessedAt = LocalDateTime.now();
    }
}
