import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public static void main(String[] args) {
        EncoderTest encoder = new EncoderTest();
        //String encode = "f-lab base64 encoding";
        String encode = "base64";

        String encodeResult = encoder.basicToBase64(encode);
        System.out.println(encodeResult);

        String decode = "Zi1sYWIgYmFzZTY0IGVuY29kaW5n";
        DecoderTest decoder = new DecoderTest();
        String decodeResult = decoder.base64ToBasic(decode);
        System.out.println(decodeResult);

    }
}
