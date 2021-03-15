import org.junit.jupiter.api.Test;

import java.util.HashMap;
public class AsciiTableTest {
    public static final int BASIC_BINARY = 8;
    public static final int BASE64_BINARY = 6;
    public static HashMap<Integer, Character> binaryToBase64;

    public AsciiTableTest() {
        binaryToBase64 = new HashMap<>();
        insertToBase64();
    }

    public static void insertToBase64() {
        int index = 0;
        for(char x = 'A'; x <= 'Z'; x++) {
            binaryToBase64.put(index++, x);
        }
        for(char x = 'a'; x <= 'z' ; x++) {
            binaryToBase64.put(index++, x);
        }
        for(char x = '0' ; x <= '9'; x++) {
            binaryToBase64.put(index++, x);
        }
        binaryToBase64.put(index++, '+');
        binaryToBase64.put(index, '/');

    }

    public static String[] bitConversion(StringBuilder before, int size, int convertSize) {
        String[] result = new String[size];
        // 6 이던 8 이던 할수있도록
        for(int i = 0; i < size; i++) {
            int index = i * convertSize;
            String binLetter = before.substring(index, index + convertSize);
            result[i] = binLetter;
        }
        return result;

    }
    public static String getKey(char value) {
        String result = "";
        for(int x: binaryToBase64.keySet()) {
            if(binaryToBase64.get(x).equals(value)) {
                result = Integer.toBinaryString(x);
            }
        }
        return result;
    }

    public static int[] binaryCodeFinal(String[] convertedBinaryList) {
        int index = 0;
        int[] numberConversion = new int[convertedBinaryList.length];
        for(String current : convertedBinaryList) {
            int num = Integer.parseInt(current, 2);
            numberConversion[index++] = num;
        }
        return numberConversion;
    }
}
