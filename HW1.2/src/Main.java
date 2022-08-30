import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 6, 3, 2, 5, 1, 4, 9};

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        int leftMarker = left;
        int rightMarker = right;
        int pivot = arr[((leftMarker + rightMarker) / 2)];

        do {
            while (arr[leftMarker] < pivot)
                leftMarker++;
            while (arr[rightMarker] > pivot)
                rightMarker--;
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int tmp = arr[leftMarker];
                    arr[leftMarker] = arr[rightMarker];
                    arr[rightMarker] = tmp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < right) {
            quickSort(arr, leftMarker, right);
        }
        if (left < rightMarker) {
            quickSort(arr, left, rightMarker);
        }
        return arr;
    }
}