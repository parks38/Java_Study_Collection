/**
 *  Base64 로 인코딩과 디코딩 구현을 위한 역할을 하고 있다.
 *  Base64 인코딩이란?
 *  바이너리 데이터를 64개의 ASCII 데이터를 이용하 표현하는 암호화/ 부호화 방법입니다.
 *
 *  인코딩해보고 싶은 문자열을 encode고 에 기입해주면 인코딩이 구현되고 출력되
 *  인코딩을 통해 받은 암호화된 코드를 decoder 를 통해 암호화 해제시켜 출력해 줍니다.
 */

public class Main {
    public static void main(String[] args) {
        Encoder encoder = new Encoder();
        String decode = encodeResult(encoder);

        Decoder decoder = new Decoder();
        decodeResult(decoder, decode);
    }

    /**
     * 일반 문자열 단어를 받아온 Encoder을 통해 Base64 로 변환 진행
     * @param encoder : Encoder 객체
     * @return result : base64 변환된 문자열
     */
    public static String encodeResult(Encoder encoder) {
        String encode = "f-lab base64 encoding\"";
        String result = encoder.basicToBase64(encode);
        System.out.println(result);
        return result;
    }

    /**
     * Base64로 변환된 decode 변수를 받아와 일반 문자열로 변환 진행
     * @param decoder : Decoder 객체
     * @param decode : bse64로 변환된 문자열
     */
    public static void decodeResult(Decoder decoder, String decode) {
        //String decode = "Zi1sYWIgYmFzZTY0IGVuY29kaW5n";
        String decodeResult = decoder.base64ToBasic(decode);
        System.out.println(decodeResult);
    }
}
