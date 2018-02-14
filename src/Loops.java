import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        int day = 19;
        int month = 10;
        int year = 1987;
        System.out.println(day + "." + month + "." + year  + " - it was " + findSeason1(month));
        System.out.println(day + "." + month + "." + year  + " - это " + findSeason2(month));
        Loops.race();
        Loops.multiTable();

        System.out.println("Введите число от 0 до 9999");
        Scanner inputNum = new Scanner(System.in);
        int number = inputNum.nextInt();
        System.out.println("Сумма цифр числа " + number + " = " + Loops.summNumbers(number));
        // Loops.throwCoin();
    }

    public static String findSeason1(int month) {
        String season1 = "winter";
        String season2 = "spring";
        String season3 = "summer";
        String season4 = "autumn";

        String result = "null";

        if (month <= 2 || month == 12) {
            result = season1;
        }
        else if (month <= 5 && month > 2) {
            result = season2;
        }
        else if (month <= 8 && month > 5) {
            result = season3;
        }
        else if (month <= 11 && month > 8) {
            result = season4;
        }
        return result;
    }

    public static String findSeason2(int month) {
        String season1 = "зима";
        String season2 = "весна";
        String season3 = "лето";
        String season4 = "осень";

        String res = "нулл";

        switch (month) {
            case 1:
            case 2:
            case 12:
                res = season1;
                break;
            case 3:
            case 4:
            case 5:
                res = season2;
                break;
            case 6:
            case 7:
            case 8:
                res = season3;
                break;
            case 9:
            case 10:
            case 11:
                res = season4;
                break;
        }
        return res;
    }

    public static void race() {
        for (int i = 1; i <= 20; i++) {
            String race = " - Race " + i;
            if (i == 6 || i == 12) {
                continue;
            }
            else if (i == 18){
                continue;
            }
            else {
                System.out.println(race);
            }
        }
    }

    public static void multiTable() {
        int i = 1;
        int k = 0;
        while (i <= 9) {
            int j = 1;
            while (j <= 9) {
                k = i * j;
                System.out.println(i + " * " + j + " = " + k);
                j++;
            }
            i++;
        }
    }

    public static void throwCoin() {

        do {
            double flag = Math.random();
            if (flag == 0.0) {
                break;
            }
            else if (flag <= 0.5) {
                System.out.println("tails");
            }
            else if (flag > 0.5) {
                System.out.println("eagle");
            }

        }
            while(true);

    }

    public static int summNumbers(int nunmber) {

        double pos4d = nunmber / 1000;
        int pos4 = (int) pos4d;
        double pos3d = (nunmber - pos4*1000) / 100;
        int pos3 = (int) pos3d;
        double pos2d = (nunmber - pos4*1000 - pos3*100) / 10;
        int pos2 = (int) pos2d;
        int pos1 = nunmber - pos4*1000 - pos3*100 - pos2*10;
        int result = pos1 + pos2 + pos3 + pos4;
        return result;

    }

}
