/**
 *  Encoding의 원리는 8 비트 바이너리 데이터를 문자 코드에 영향 받지 않는 공통 ASCII 영역으로만 구성되어있는
 *  Base 64로 바꾸어 인코딩 하는 개념입니다.
 *  8 비트인 일반적인 문자를 6비트로 쪼개어 데이터를 변환합니다.
 *  이 과정에서 혼한을 막기위해 24 비트씩 묶어서 문자열을 처리합니다.
 *
 *  동작 방법 :
 *  1. 문자열을 일반 1 바이트 바이너리 데이터로 변환시킨다.
 *  2. 변환된 8 비트 데이터를 6 비트 데이터로 변환시켜줍니다.
 *  3. 변환된 6 비트 데이터를 Base64 table을 참고하여 문자열을 생성합니다.
 *
 */
public class Encoder extends Base64 {
    public StringBuilder convertBinary;
    public StringBuilder result;

    public Encoder() {
        convertBinary = new StringBuilder();
        result = new StringBuilder();
    }

    /**
     * 주어진 문자열을 base64로 인코딩 구현하는 기능
     * 문자열을 8비티 바이너리 데이터로 변환후 그것을 6 비트 바이너리 데이터로 쪼개
     * base64 로 해당 숫자를 인코딩 시켜준다.
     * @param encode : 변환할 문자열
     * @return : 변환된 문자열 리턴
     */
    public String basicToBase64(String encode) {
        charToInteger(encode);
        int[] numberConversion = bitConversion(convertBinary, BASE64_BINARY);
        return finalConversion(numberConversion);
    }

    /**
     * 주어진 일반 문자열 코드를 받아 알파벳에 해당하는 바이너리 데이터를의 조합을
     * 구한후 남는 공간 (24 비트로 묶음)이 없는지 validation check
     * @param encode : 주어진 일반 문자열
     */
    private void charToInteger(String encode) {
        for(int i = 0; i < encode.length(); i++) {
            char letter = encode.charAt(i);
            StringBuilder code = new StringBuilder(Integer.toBinaryString(letter));
            while(code.length() != BASIC_BINARY) {
                code.insert(0, "0");
            }
            convertBinary.append(code);
        }
        int checkIndexes = (encode.length() * BASIC_BINARY) % LEAST_COMMON_NUM;
        if(checkIndexes != 0) {
            checkIndex(checkIndexes, convertBinary);
        }

    }

    /**
     * 주어진 바이너리 데이터들이 숫자로 변환된 조합을 가지고
     * base64에서의 문자열을 탐색한 후 결과를 리턴.
     * @param numberConversion : 6 바이트 바이너리 데이터 decimal type
     */
    private String finalConversion(int[] numberConversion){
        for(int i : numberConversion) {
            result.append(binaryToBase64.get(i));
        }
        return result.toString();
    }
}
