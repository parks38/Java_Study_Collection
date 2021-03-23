public class EncoderTest extends Base64Test {
    public StringBuilder convertBinary;
    public StringBuilder result;

    public EncoderTest() {
        convertBinary = new StringBuilder();
        result = new StringBuilder();
    }

    public String basicToBase64(String encode) {
        // 2. 문자를 binary 넘버 로 변환
        charToInteger(encode);
        // 3. 8bit 를 6비트로 변환
        int size = (encode.length()  * BASIC_BINARY ) / BASE64_BINARY;
        String[] convertBinaryNum = bitConversion(convertBinary, size, BASE64_BINARY);
        int[] numberConversion = binaryCodeFinal(convertBinaryNum);
        // 4. 바이너리 넘버를 문자로 변환
        return finalConversion(numberConversion);
    }

    private StringBuilder charToInteger(String encode) {
        for(int i = 0; i < encode.length(); i++) {
            char letter = encode.charAt(i);
            StringBuilder code = new StringBuilder(Integer.toBinaryString(letter));
            while(code.length() != BASIC_BINARY) {
                code.insert(0, "0");
            }
            convertBinary.append(code);
        }
        return convertBinary;
    }

    private String finalConversion(int[] numberConversion){
        for(int i : numberConversion) {
            result.append(binaryToBase64.get(i));
        }
        return result.toString();
    }


}
