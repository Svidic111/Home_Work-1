package Arrays;

public class Arrays2 {
    public static void main(String[] args) {
        int[][] arr100 = new int[10][10];
        for (int i = 0; i < arr100.length; i++) {
            for (int j = 0; j < arr100[i].length; j++) {
                arr100[i][j] = rnd();
            }
        }
        printArray(arr100);
        System.out.println("Сумма всех чисел массива = " + summAllArray(arr100));
        System.out.println("Среднее арифметическое всех чисел массива = " + avarageArray(arr100));

    }

    public static int rnd() {
        return (int) (Math.random() * 41) - 20;
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + ";\t");
            }
            System.out.println();
        }
    }

    public static int summAllArray(int[][] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length - 1; j++) {
                int a = arr[i][j];
                result = a + arr[i][j +1];
            }
        }
        return result;
    }

    public static double avarageArray(int[][] arr) {
        int result = 0;
        double res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length - 1; j++) {
                int a = arr[i][j];
                result = a + arr[i][j +1];
            }
        }
        return res = (double) result / (arr.length * arr[0].length);
    }

}
