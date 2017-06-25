package problems;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by alex on 11/14/16.
 * Problem: https://projecteuler.net/problem=59
 */
public class P059 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String cipher = in.next();
        List<String> splitList = Arrays.asList(cipher.split(","));
        char[] ascii_cipher = new char[splitList.size()];
        for (int i = 0; i < splitList.size(); i++) {
            ascii_cipher[i] = (char) Integer.parseInt(splitList.get(i));
        }

        // need to cycle through all possible keys
        char[] key = new char[3];
        key[0] = 97;
        key[1] = 97;
        key[2] = 97;

        for (int i = 0; i <= 26; i++) {
            for (int j = 0; j <= 26; j++) {
                for (int k = 0; k <= 26; k++) {
                    char[] ascii_decrypted = decrypt(ascii_cipher, key);
                    if (checkPossible(ascii_decrypted)) {
                        printDecrypted(ascii_decrypted);
                    }
                    key[0]++;
                }
                key[1]++;
            }
            key[2]++;
        }
    }

    private static char[] decrypt(char[] encrypted, char[] key) {
        char[] ascii_decrypted = new char[encrypted.length];
        for (int i = 0; i < encrypted.length; i++) {
            int byte_index = encrypted.length % key.length;
            byte key_byte = (byte) key[byte_index];
            byte encrypted_byte = (byte) encrypted[i];
            ascii_decrypted[i] = (char) (key_byte ^ encrypted_byte);
        }
        return ascii_decrypted;
    }

    private static boolean checkPossible(char[] ascii) {
        for (int i = 0; i < ascii.length; i++) {
            if (ascii[i] < 32 ) {
                return false;
            } /**else if (ascii[i] > 90 && ascii[i] < 96) {
                return false;
            } else if (ascii[i] > 122) {
                return false;
            }*/
        }
        return true;
    }

    private static void printDecrypted(char[] decrypted) {
        for (int i = 0; i < decrypted.length; i++) {
            System.out.print(decrypted[i]);
        }
    }
}
