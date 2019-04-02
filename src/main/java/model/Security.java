package model;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Security {

    public static String getSalt() {
        StringBuilder salt = new StringBuilder();
        int saltLength = 25;
        int min = 33;
        int max = 126;

        for (int i = 0; i < saltLength; i++) {
            Random r = new Random();
            char ch = (char) (r.nextInt(max - min) + min);
            salt.append(ch);
        }

        return salt.toString();
    }

    public static String getHashPassword(String password, String salt) {
        String hashPassword = getHash(password);
        String hashSalt = getHash(salt);

        return getHash(hashPassword + hashSalt);
    }

    private static String getHash(String string) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(string.getBytes(StandardCharsets.UTF_8));

            return String.format("%064x", new BigInteger(1, messageDigest));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
