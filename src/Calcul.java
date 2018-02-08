import java.util.Scanner;

public class Calcul {

    public static void main(String[] args) {
        double num1;
        double num2;
        double result = 0;
        String action;

        System.out.println("Введите первое число");
        Scanner inputNum1 = new Scanner(System.in);
        num1 = inputNum1.nextFloat();

        System.out.println("Введите второе число");
        Scanner inputNum2 = new Scanner(System.in);
        num2 = inputNum2.nextFloat();

        System.out.println("Введите действие");
        Scanner inputAction = new Scanner(System.in);
        action = inputAction.nextLine();

        switch (action) {
            case "+":
                result = summation(num1, num2);
                break;
            case "-":
                result = subtraction(num1, num2);
                break;
            case "*":
                result = multiplication(num1, num2);
                break;
            case "/":
                result = division(num1, num2);
                break;
            case "%":
                result = modul(num1, num2);
                break;
        }

        System.out.println(num1 + " " + action +  " " + num2 + " = " + result);
        System.out.println("Среднее арифметическое чисел " + num1 + " и " +  num2 + " = " + avg(num1, num2));
        System.out.println("Квадрат первого числа равен " + num1 + "^2 = " + pov(num1));
        System.out.println(num2 + "% от чилса " + num1 + " = " + percent(num1, num2));
        System.out.println("Число " + percent(num1, num2) + " переведенное в тип long = " + BitLogic.castToLong(percent(num1, num2)));
        System.out.println("Проверка знака числа " + num1 + " --> " + BitLogic.checkSign(num1));
        System.out.println("Проверка на четность числа " + num1 + " --> " + BitLogic.checkEvenNumber(num1));
        System.out.println(num1 + " / 4 = " + BitLogic.bitWiseDivByFour(num1));


    }

    public static double summation(double number1, double number2) {
        double res = number1 + number2;
        return res;
    }

    public static double subtraction(double number1, double number2) {
        double res = number1 - number2;
        return res;
    }

    public static double multiplication(double number1, double number2) {
        double res = number1 * number2;
        return res;
    }

    public static double division(double number1, double number2) {
        double res = number1 / number2;
        return res;
    }

    public static double modul(double number1, double number2) {
        double res = number1 % number2;
        return res;
    }

    public static double avg(double number1, double number2) {
        double res = (number1 + number2) / 2 ;
        return res;
    }

    public static double pov(double number1) {
        double res = number1 * number1;
        return res;
    }

    public static double percent(double number1, double number2) {
        double res = number1 / 100 * number2;
        return res;
    }

}
