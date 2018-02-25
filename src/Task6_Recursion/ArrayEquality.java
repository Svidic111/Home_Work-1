package Task6_Recursion;

public class ArrayEquality {
    public static void main(String[] args) {
        char[] array1 = {'a', 'b', 'c', 'd', 'e'};
        char[] array2 = {'a', 'b', 'c', 'd', 'e'};
        System.out.println(checkArrEqual(array1, array2) + " ");
    }

    public static boolean checkArrEqual(char[] arr1, char[] arr2) {
        if(arr1.length != arr2.length) {
            return false;
        }
        if(arr1 == null || arr2 == null) {
            return false;
        }
        int j = 0;
        for (int ar1 : arr1) {
            if (ar1 != arr2[j]) {  // если вместо != поставить == то выдает всегда true... Не знаю что не так.
                return false;
            }
            j++;
        }
        return true;
    }

}
