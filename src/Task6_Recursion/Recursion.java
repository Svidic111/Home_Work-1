package Task6_Recursion;

public class Recursion {
    public static void main(String[] args) {
        int n = 30;
        final int k = 3;
        System.out.printf("Сумма ряда %d*1 + %d*2 +%d*3 + … + %d*%d" + " = " + recursiveSumm(k, n), k, k, k, k, n);
    }

    public static long recursiveSumm(int k, int n) {
        long result = 0;
        if(n == 1) {
            result = k;
        }
        else {
            result = k * n + recursiveSumm(k, n-1);
        }
        return result;
    }
}
