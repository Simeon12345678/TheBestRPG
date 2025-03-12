import java.util.concurrent.ThreadLocalRandom;

public class Utils <T extends Number> {
    // insertion sort is used for the enemy selection process
    public static int[] insertionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[1];
            int j = i - 1;
            while (j >= 0 && temp <= arr[j]) {
                // swap
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = temp;
        }
        return arr;
    }


    public T generateRandomNumber(T rangeFrom, T rangeTo) {
        if (rangeFrom.doubleValue() >= rangeTo.doubleValue()) {
            System.err.println("rangeFrom cannot be greater than or equal to rangeTo!");
        }

        if (rangeFrom instanceof Integer) {
            // returns randomized integer in range
            // (rangeTo - rangeFrom + 1) + rangeFrom ensures calling the method with parameters such as (1, 2) may return 1 and 2 and not only 1 as written before
            int randInt = ThreadLocalRandom.current().nextInt(rangeTo.intValue() - rangeFrom.intValue() + 1) + rangeFrom.intValue();
            return (T) Integer.valueOf(randInt);
        } else if (rangeFrom instanceof Double) {
            // returns randomized double in range
            double randDouble = ThreadLocalRandom.current().nextDouble(rangeFrom.doubleValue(), rangeTo.doubleValue() + Math.ulp(rangeTo.doubleValue()));
            return (T) Double.valueOf(randDouble);
        } else {
            System.err.println("Unable to return randomized number, perhaps it is an issue with rangeFrom? " + rangeFrom);
            return rangeFrom;
        }
    }

    //TODO rogue (game) esq map generator all in ascii

}


