import repositories.InMemoryRepository;
import repositories.URLRepository;
import services.CleanupService;
import services.URLService;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        URLRepository urlRepository = new InMemoryRepository();
        URLService urlService = new URLService(urlRepository);
        CleanupService cleanupService = new CleanupService(urlRepository);

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n1. Shorten URL \n2. Cleanup expired URLs");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter long URL");
                    String longUrl = sc.nextLine();
                    String shortenedUrl = urlService.shortenURL(longUrl);
                    System.out.println("Shortened URL: " + shortenedUrl);
                    break;

                case 2:
                    cleanupService.cleanupExpiredUrls();
                    System.out.println("Expired URLs cleaned up!");
                    break;

                default: return;
            }
        }
    }
}

// URLShorteningService -> Kind of similar to bit.ly
// Main functionalities
// 1.The shortened link is randomly generated an should be of 16 characters
// 2.There should be a time limit for each shortened link -> max 30 days after accessing it realtime

// Optional functionality
// 1.Delete
