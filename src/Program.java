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
            System.out.println("\n1. Shorten URL \n2. Get all URLs \n3. Cleanup expired URLs \n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter long URL ");
                    String longUrl = sc.nextLine();
                    String shortenedUrl = urlService.shortenURL(longUrl);
                    System.out.println("Shortened URL: " + shortenedUrl);
                    break;

                case 2:
                    urlService.displayAllUrls();
                    break;

                case 3:
                    cleanupService.cleanupExpiredUrls();
                    System.out.println("Expired URLs cleaned up! ");
                    break;

                case 4:
                    System.out.println("Exiting... ");
                    sc.close();
                    return;

                default: System.out.println("Invalid choice. Try again. ");
            }
        }
    }
}