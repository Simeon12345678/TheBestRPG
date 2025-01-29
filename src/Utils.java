import java.util.concurrent.ThreadLocalRandom;

public class Utils<T extends Number> {
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
            return (T) (Integer) ThreadLocalRandom.current().nextInt(rangeFrom.intValue(), rangeTo.intValue());
        } else if (rangeFrom instanceof Double) {
            // returns randomized double in range
            return (T) (Double) ThreadLocalRandom.current().nextDouble(rangeFrom.doubleValue(), rangeTo.doubleValue());
        } else {
            System.err.println("Unable to return randomized number, perhaps it is an issue with rangeFrom? " + rangeFrom);
            return rangeFrom;
        }
    }

    //TODO rogue (game) esq map generator all in ascii

}


