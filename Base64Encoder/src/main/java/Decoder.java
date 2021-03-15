/**
 * Decoder 은 Encoder과 반대로 작동합니다.
 * 동작 방법 :
 *      1. Base64 문자열을 받아와 매핑되어있는 value값 찾기
 *      2. 변환된 6 비트 데이터를 8 비트 데이터로 변환시켜줍니다.
 *      3. 변환된 8 비트 데이터를 ASCII table에 매핑되어 있는 문자열을 생성합니다.
 */
public class Decoder extends AsciiTable{
    public StringBuilder result;
    public StringBuilder binary;

    public Decoder() {
        result = new StringBuilder();
        binary = new StringBuilder();
    }

    /**
     * 주어진 base64 문자열을 일반 문자열로 디코딩 구현하는 기능
     * 문자열을 6비티 바이너리 데이터로 변환후 그것을 8 비트 바이너리 데이터로 쪼개
     * base64 로 해당 숫자를 인코딩 시켜준다.
     * @param decode : base64 문자열
     * @return : 일반 문자열
     */
    public String base64ToBasic(String decode){
        charToBinaryBase64(decode);
        int[] numberConversion = bitConversion(binary, BASIC_BINARY);
        return finalConversion(numberConversion);
    }

    /**
     * 주어진 Base64문자열을 해당 table과 매핑되어있는 바이너리 데이터를 찾아
     * 구한 후 남는 공간 (24 비트로 묶음)이 없는지 validation check
     * @param decode: base64 문자열
     */
    private void charToBinaryBase64(String decode) {
        for(int i = 0; i < decode.length(); i++) {
            char letter = decode.charAt(i);
            StringBuilder code = new StringBuilder(getKey(letter));
            while(code.length() != BASE64_BINARY) {
                code.insert(0, "0");
            }
            binary.append(code);
        }
        int checkIndexes = (decode.length() * BASE64_BINARY) % LEAST_COMMON_NUM;
        if(checkIndexes != 0) {
            checkIndex(decode.length(), binary);
        }
    }

    /**
     * 주어진 바이너리 데이터들이 숫자로 변환된 조합을 가지고
     * 해당 숫자에 매핑되어있는 일반 ASCII 문자열 조합을 구하여 리턴
     * @param numberConversion : 8 비트 바이너리 데이터 decimal
     * @return : ASCII 문자열
     */
    private String finalConversion(int[] numberConversion){
        for(int i : numberConversion) {
            result.append((char) i);
        }
        return result.toString();
    }

}
