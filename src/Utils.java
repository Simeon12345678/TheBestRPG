public class Utils {
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

    //TODO rogue (game) esq map generator all in ascii

}
