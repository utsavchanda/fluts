import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        int[][] arr = new int[][] {
            {12, 3, 10, 7, 16, 5},
            {7, 3, 11, 9, 10},
            {1, 2, 3, 4, 10, 16, 10, 4, 16}
        };

        Result[] results = getMaxProfit(arr);
        for (Result result:results) {
            System.out.println("Profit " + result.getProfit() + " Count " + result.getCount());
        }
    }

    private static Result[] getMaxProfit(int[][] arr) {
        List<Result> results = new ArrayList<>(arr.length);
        for (int[] a: arr) {
            for (int i=0; i<a.length; i++){
                a[i] = 10 - a[i];
            }
            int sum = 0, maxSum = 0;
            Result result = new Result();
            results.add(result);
            for (int i=0; i<a.length; i++) {
                sum += a[i];
                if (maxSum < sum) {
                    maxSum = sum;
                    result.setCount(i+1);
                    result.setProfit(maxSum);
                }
            }
        }
        return results.toArray(new Result[results.size()]);
    }
}
