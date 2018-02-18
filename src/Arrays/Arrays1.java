package Arrays;

import java.util.Scanner;

public class Arrays1  {
    public static void main(String[] args) {
        System.out.println("Введите число");
        Scanner inputNum = new Scanner(System.in);
        int number = inputNum.nextInt();
        System.out.println(number +  palindromness(number));
    }

   public  static String palindromness (int number) {
        int testingNum = number;
        int numLength = Integer.toString(testingNum).length(); // вычисляем длину числа(длину массива)
        int a = testingNum;
        int[] arrNum = new int[numLength];          // создаем массив из цифр числа
        for (int i =  numLength - 1; i >= 0; i--) { // заполняем массив
            int b = a % 10;
            arrNum[i] = b;
            a /= 10;
        }
        String result = " - палиндром";
       for (int i = 0, j = numLength - 1; i < numLength / 2; i++, j--) {  // проверка палиндромности массива
            if(arrNum[i] != arrNum[j]) {
                result = " -  не палиндром";
            }
        }
       return result;
      /* StringBuilder sb=new StringBuilder(); // склеиваем отсвапленный массив в число
       for(int i=0; i < arrNum.length; i++)
           sb.append(arrNum[i]);
       int reverseNum = (int) Long.parseLong(sb.toString());

       String result = "";                  // проверка палиндромности
        if (testingNum == reverseNum) {
            result = " - палиндром";
        }
        else {
            result = " -  не палиндром";
        }
        return result;*/
    }


}
