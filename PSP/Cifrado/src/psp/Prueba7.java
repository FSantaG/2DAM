
package psp;

/**
 * Encriptado y Desencriptado de mensajes
 * @author Matías Daniel Jara Cubas y Fernando Santamaría
 */
import java.io.BufferedReader;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.nio.*;
import java.nio.charset.StandardCharsets;

class EncriptadoPaco {
    public static void main(String[] args) {
        //TODO Hacer que la entrada y salida de info sea mediante archivos TXT
        Scanner optionChoosed = new Scanner(System.in);
        String option;
        do{
            option = "";
            System.out.println("Selecciona una opción:");
            System.out.println("1.- Encriptar Mensaje");
            System.out.println("2.- Desencriptar Mensaje");
            System.out.println("e.- Salir");
            option = optionChoosed.nextLine();
        }while(!"1".equals(option)&&
                !"2".equals(option)&& 
                !"E".equals(option.toUpperCase()) );
        
        Scanner sc = new Scanner(System.in, StandardCharsets.ISO_8859_1);
        switch(option){
            case "1":
                System.out.println("Texto a encriptar: ");
                String decryptedText = sc.nextLine();
                
                BigInteger key = generateKey(16, decryptedText);
                String encryptedText = encrypt(decryptedText, key).toString();
                
                System.out.println("Texto cifrado: " + encryptedText);
                System.out.println("Llave de Cifrado: " + key);
                break;
            case "2":
                System.out.println("Texto para desencriptar: ");
                String encryptedTextToDecrypt = sc.nextLine();
                System.out.println("Llave de Descifrado: ");
                BigInteger decryptionKey = new BigInteger(sc.nextLine());
                
                String decryptedPlainText = decrypt(encryptedTextToDecrypt, decryptionKey).toString();
                System.out.println("Texto Desencriptado: " + decryptedPlainText);
                break;
            case "e":
            case "E":
                break;
        }
        /*Scanner sc = new Scanner(System.in, StandardCharsets.ISO_8859_1);
        System.out.println("Txto");
        String decryptedText = sc.nextLine();
        System.out.println(decryptedText);
        //String decryptedText = "Hólá BuËnas Días";

        BigInteger key = generateKey(2, decryptedText);
        System.out.println("Key: " + key);
        System.out.println("Key Bytes: " + Arrays.toString(key.toByteArray()));
        System.out.println();
        System.out.println("Encryption");
        System.out.println("Text: " + decryptedText);

        String cipher = encrypt(decryptedText, key).toString();
        System.out.println("Encrypted Cipher: " + cipher);
        
        String decryptedPlainText = decrypt(cipher, key).toString();
        System.out.println("Decrypted Plain Text: " + decryptedPlainText);*/
    }
    
    public static StringBuffer encrypt(String text, BigInteger key) {
        var result = new StringBuffer();

        byte[] keyBytes = key.toByteArray();

        distortKey(keyBytes);

        if (keyBytes.length > text.length()) {
            Character[] distinctChars = distinctChars(text.toCharArray());
            // Add salt
            var random = new SecureRandom();
            int missingCharsCount = keyBytes.length - text.length();
            for (int i = 0; i < missingCharsCount; i++) {
                int randomIndex = random.nextInt(distinctChars.length);
                text += distinctChars[randomIndex];
            }
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = (char) (((int) text.charAt(i) + keyBytes[i % (keyBytes.length - 1)]));
            result.append(ch);
        }

        return result;
    }

    public static StringBuffer decrypt(String cipher, BigInteger key) {
        var result = new StringBuilder();

        byte[] keyBytes = key.toByteArray();

        distortKey(keyBytes);

        for (int i = 0; i < cipher.length(); i++) {
            char ch = (char) (((int) cipher.charAt(i) - keyBytes[i % (keyBytes.length - 1)]));
            result.append(ch);
        }

        // Remove salt
        return new StringBuffer(result.substring(0, keyBytes[0]));
    }

    /**
     * Shifts each byte in the key by the length of the string (first index).
     * Alternates between (+) and (-).
     *
     * @param key byte representation of the key
     */
    private static void distortKey(byte[] key) {
        for (int i = 1; i < key.length; i++) {
            if (i % 2 == 0) {
                key[i] += key[0];
            } else {
                key[i] -= key[0];
            }
        }
    }

    private static Character[] distinctChars(char[] array) {
        var set = new HashSet<Character>();
        for (char c : array) {
            set.add(c);
        }
        return set.toArray(Character[]::new);
    }

    private static BigInteger generateKey(int keyLength, String plainText) {
        var random = new SecureRandom();

        byte[] bytes = new byte[keyLength];
        bytes[0] = (byte) plainText.length();
        for (int i = 1; i < keyLength; i++) {
            bytes[i] = (byte) (random.nextInt(255) - 128); // -128 to 127
        }

        return new BigInteger(bytes);
    }
}
