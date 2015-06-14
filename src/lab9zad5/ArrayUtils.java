package lab9zad5;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Predicate;

public class ArrayUtils {

    static void filterNumbers(Predicate<Integer> condition, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (condition.test(array[i])) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] numbers = new int[20];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(40) + 10;
        }
        System.out.println(Arrays.toString(numbers));
        Predicate<Integer> even = x -> x % 2 == 0;
        System.out.print("Even Numbers: ");
        filterNumbers(even, numbers);
        Predicate<Integer> interval = x -> x >= 30 && x <= 40;
        System.out.print("Numbers in [30,40]: ");
        filterNumbers(interval, numbers);
        System.out.print("Prime Numbers: ");
        Predicate<Integer> prime = x -> {
            for (int i = 2; 2 * i < x; i++) {
                if (x % i == 0) {
                    return false;
                }
            }
            return true;
        };
        filterNumbers(prime, numbers);
    }
}
