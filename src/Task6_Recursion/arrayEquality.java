package Task6_Recursion;

public class arrayEquality {
    public static void main(String[] args) {
        char[] array1 = {'a', 'b', 'c', 'd', 'e'};
        char[] array2 = {'a', 'b', 'c', 'd', 'e'};
        System.out.println(checkArrEqual(array1, array2) + " ");
    }

    public static boolean checkArrEqual(char[] arr1, char[] arr2) {
        boolean answer = true;
        for (int i : arr1) {
            if (arr1 != arr2) {  // если вместо != поставить == то выдает всегда true... Не знаю что не так.
                answer = false;
            }
        }
        return answer;
    }
}