/**
 * This class, `TugasCleanCode`, implements methods for Caesar Cipher encryption and decryption.
 * Caesar Cipher is a simple yet classic encryption algorithm that shifts each letter in a text
 * by a specified number of positions.
 *
 * @author Lenovo (or your name)
 */
package tugascleancode;

import java.util.Scanner;

public class TugasCleanCode {

    /**
     * Encrypts a given plain text using the Caesar Cipher algorithm with a specified shift value.
     *
     * @param plainText The text to be encrypted.
     * @param shift The number of positions to shift each letter (positive for right shift, negative for left shift).
     * @return The encrypted text.
     */
    public static String encrypt(String plainText, int shift) {
        StringBuilder encryptedText = new StringBuilder();
        for (char ch : plainText.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = (Character.isUpperCase(ch)) ? 'A' : 'a';
                encryptedText.append((char) ((ch - base + shift) % 26 + base));
            } else {
                encryptedText.append(ch);
            }
        }
        return encryptedText.toString();
    }

    /**
     * Decrypts a given encrypted text using the Caesar Cipher algorithm with the same shift value used for encryption.
     * Decryption is essentially the reverse of encryption.
     *
     * @param encryptedText The text to be decrypted.
     * @param shift The number of positions to shift each letter during decryption (typically the negative of the shift value used for encryption).
     * @return The decrypted text (original plain text).
     */
    public static String decrypt(String encryptedText, int shift) {
        return encrypt(encryptedText, -shift); // Decryption is the inverse of encryption
    }

    /**
     * The main method serves as the program's entry point. It interacts with the user to obtain the plain text,
     * shift value, and displays the encrypted and decrypted results.
     *
     * @param args Command-line arguments (unused in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kata yang ingin dienkripsi: ");
        String plainText = scanner.nextLine();

        System.out.print("Masukkan nilai pergeseran (shift): ");
        int shift = scanner.nextInt();

        System.out.println("--------------------------------");

        String encryptedText = encrypt(plainText, shift);
        System.out.println("Hasil Enkripsi: " + encryptedText);

        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Teks Asli: " + decryptedText);
    }
}