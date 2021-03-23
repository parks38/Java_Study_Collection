import org.junit.jupiter.api.Test;

public class DecoderTest extends Base64Test {
    public StringBuilder result;
    public StringBuilder binary;

    public DecoderTest() {
        result = new StringBuilder();
        binary = new StringBuilder();
    }

    public String base64ToBasic(String encode){
        charToBinaryBase64(encode);
        int size = (encode.length()  * BASE64_BINARY) / BASIC_BINARY;
        String[] convertBinaryValue = bitConversion(binary, size, BASIC_BINARY);
        int[] numberConversion = binaryCodeFinal(convertBinaryValue);
        return finalConversion(numberConversion);
    }

    @Test
    private StringBuilder charToBinaryBase64(String encode) {
        for(int i = 0; i < encode.length(); i++) {
            char letter = encode.charAt(i);
            StringBuilder code = new StringBuilder(getKey(letter));
            while(code.length() != BASE64_BINARY) {
                code.insert(0, "0");
            }
            binary.append(code);
        }
        return binary;
    }

    private String finalConversion(int[] numberConversion){
        for(int i : numberConversion) {
            result.append(Character.toString((char) i));
        }
        return result.toString();
    }

}
