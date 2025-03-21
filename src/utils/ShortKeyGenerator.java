package utils;

import java.util.Random;

public class ShortKeyGenerator {
    private static final String CHARSET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int urlLength = 16;
    private static final Random random = new Random();

    public static String generateKey() {
        StringBuilder sb = new StringBuilder();

        sb.append("http://short.ly/");
        for(int idx=0; idx<urlLength; idx++) {
            sb.append(CHARSET.charAt(random.nextInt(CHARSET.length())));
        }
        return sb.toString();
    }
}
