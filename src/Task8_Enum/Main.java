package Task8_Enum;

import com.sun.org.apache.bcel.internal.generic.MONITORENTER;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int month = 0;
        int year = 0;
        System.out.println("Введите номер месяца");
        Scanner inputMonth = new Scanner(System.in);
        month = inputMonth.nextInt();

        if (month > 12) {
            System.out.println("Введите корректный номер месяца");
            return;
        }

        System.out.println("Введите год");
        Scanner inputYear = new Scanner(System.in);
        year = inputYear.nextInt();

        System.out.println(year + " " + daysInMonth(month, year).name() + " has " + daysInMonth(month, year).getNumOfDays() + " days");
    }

    public static Month daysInMonth(int month, int year) {
        Month monthName = Month.JANUARY;
            switch (month) {
                case 1:
                    break;
                case 2:
                    if(year % 4 == 0) {
                    monthName = Month.FEBRUARY2;}
                    else monthName = Month.FEBRUARY;
                    break;
                case 3:
                    monthName = Month.MARCH;
                    break;
                case 4:
                    monthName = Month.APRIL;
                    break;
                case 5:
                    monthName = Month.MAY;
                    break;
                case 6:
                    monthName = Month.JUNE;
                    break;
                case 7:
                    monthName = Month.JULY;
                    break;
                case 8:
                    monthName = Month.AUGUST;
                    break;
                case 9:
                    monthName = Month.SEPTEMBER;
                    break;
                case 10:
                    monthName = Month.OCTOBER;
                    break;
                case 11:
                    monthName = Month.NOVEMBER;
                    break;
                case 12:
                    monthName = Month.DECEMBER;
                    break;
            }


        return monthName;
    }

}
