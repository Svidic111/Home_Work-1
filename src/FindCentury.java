import java.util.Scanner;

public class FindCentury {
    public static void main(String[] args) {
        System.out.println("Введите любой год нашей эры");
        Scanner inputYear = new Scanner(System.in);
        int year = inputYear.nextInt();

        System.out.println("Год " + year + " соотвествует " + century(year) + " веку нашей эры.");
    }

    public static int century(int year) {
        int result = 0;
        for (int i = 1; i <= 21; i++) {
            if (year <= i * 100) {
                result = i;
                break;
            }
        }
        return result;
    }
}
