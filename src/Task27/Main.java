package Task27;

public class Main {

    public static long processPositiveNumbers(int[] nums, char op) throws NonZeroArgsException {
        long result = 1;
        for (int num : nums) {
            if (num <= 0) {
                throw new NonZeroArgsException("Arguments are less or equal zero.");
            }
            switch (op) {
                case '+' :
                    result += num;
                    break;
                case '-' :
                    result -= num;
                    break;
                case '*':
                    result *= num;
                    break;
                default:
                    throw new InvalidOperationException("Not supported operation.");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 16, 3, 12, 2};
        int[] arr2 = {5, 16, -3, 12, 2};
        int[] arr3 = {5, 16, 0, 12, 2};

        try {
            System.out.println(processPositiveNumbers(arr2, '/'));
        } catch (NonZeroArgsException e) {
            e.printStackTrace();
        }
    }
}
