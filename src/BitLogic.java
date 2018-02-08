public class BitLogic {

    public static long castToLong(double value) {
        long res = (long) value;
        return res;
    }

    public static long checkSign(double value) {
        byte a = (byte) value;
        byte b = (byte) -128;
        byte res = (byte) (a & b);
        return res;
    }

    public static int checkEvenNumber(double value) {
        int a = (int) value;
        int res1 = a & 1;
        int result = res1 ^ 1;
        return result;
    }

    public static long bitWiseDivByFour(double value) {
        long result = (long) value >> 2;
        return result;
    }
}
