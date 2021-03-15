import java.util.HashMap;

/**
 * Base64로 변환하기 위해 필요한 공통 기능들을 담고있습니다.
 * Base64는 (A-Z) (a-z) (0-9) (+, /) 총 64개의 문자열로 구성된 코드이다.
 * 핵심은 바이너리 데이터를 스트링으로 변경하는 인코딩 방식으로 이메일을 통한 바이너리 데이터
 * 전송에 많이 쓰입니다.
 * <p>
 * [공통 기능]
 * - binaryToBase64 : Base64의 모든 binary number 와 ASCII code 조합으로 구성된 map
 * - 6바이트 -> 8 바이트 혹은 8 바이트 -> 6 바이트로 변환 기능
 * - binaryCode를 숫자로 변환시켜주는 기능
 */
public class AsciiTable {
    public static final int BASIC_BINARY = 8;
    public static final int BASE64_BINARY = 6;
    public static final int LEAST_COMMON_NUM = 24;
    public static HashMap<Integer, Character> binaryToBase64;

    public AsciiTable() {
        binaryToBase64 = new HashMap<>();
        insertToBase64();
    }

    /**
     * 64개의 문자열로 구성되 있는 문자들의 집합
     * 해당 데이터를 이용하여 Base64로 인코딩
     */
    public static void insertToBase64() {
        int index = 0;
        for (char x = 'A'; x <= 'Z'; x++) {
            binaryToBase64.put(index++, x);
        }
        for (char x = 'a'; x <= 'z'; x++) {
            binaryToBase64.put(index++, x);
        }
        for (char x = '0'; x <= '9'; x++) {
            binaryToBase64.put(index++, x);
        }
        binaryToBase64.put(index++, '+');
        binaryToBase64.put(index, '/');

    }

    /**
     * 바이너리 데이터 단위 변환하는 기능
     * basic (8 bit) -> base 64 (6 bit) || base 64 (6 bit) -> basic (8 bit)
     * 그리고 변환된 바이너리 데이터를 decimal 숫자로 변환시키는 기능
     *
     * @param binaryBefore : 변환 전 바이너리 데이터
     * @param scope        : 문자열을 짜르게 될 범위
     * @return : 변환된 바이너리 데이터의 숫자 집합.
     */
    public static int[] bitConversion(StringBuilder binaryBefore, int scope) {
        int size = binaryBefore.length() / scope;
        String[] convertedBinaryList = new String[size];
        for (int i = 0; i < size; i++) {
            int index = i * scope;
            String binaryAfter = binaryBefore.substring(index, index + scope);
            convertedBinaryList[i] = binaryAfter;
        }

        int index = 0;
        int[] numberConversion = new int[convertedBinaryList.length];
        for (String current : convertedBinaryList) {
            int num = Integer.parseInt(current, 2);
            numberConversion[index++] = num;
        }
        return numberConversion;

    }

    /**
     * binaryToBase64 에서 value를 이용하여 key를 찾는 기능
     *
     * @param value : binary number
     * @return : 해당 value의 key
     */
    public static String getKey(char value) {
        String result = "";
        for (int num : binaryToBase64.keySet()) {
            if (binaryToBase64.get(num).equals(value)) {
                result = Integer.toBinaryString(num);
            }
        }
        return result;
    }

    /**
     * 데이터를 쪼개는 작업 중 혼란을 막기위해
     * 최송공배수인 24비트로 작업을 문자열을 묶어서 처리합니다.
     * @param count : 부족한 바이트 개수
     * @param binaryCode: 최초 문자열의 바이너리 데이터 집합
     */
    public void checkIndex(int count, StringBuilder binaryCode) {
        while(count != 0) {
            binaryCode.append("0");
            count--;
        }
    }

}
