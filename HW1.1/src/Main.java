public class Main {
    public static final int SIZE = 10; // через эту переменную можно выбрать любой желаемый разер двумерного массива.
    public static long seed = System.currentTimeMillis();

    public static void main(String[] args) {
        int[][] matrix = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = Math.abs(rand());
                assert matrix[i][j] >= 0;
            }
        }

        System.out.printf("Двумерный массив размером %d на %d, сформированный из случайных чисел от 0 до 999:\n", SIZE, SIZE);
        printMatrix(matrix);

        assert findMax(matrix) > findMin(matrix);
        assert findMax(matrix) > findAvg(matrix);
        assert findAvg(matrix) > findMin(matrix);

        System.out.println("Минимальное значение из двумерного массива: min = " + findMin(matrix) + ",\n" +
                "Максимальное значение из двумерного массива: max = " + findMax(matrix) + ",\n" +
                "Среднее значение из двумерного массива: avg = " + findAvg(matrix) + ".");
    }

    static int rand() {
        long a = 25214903917L;
        int c = 11;
        long m = 281_474_976_710_656L;
        seed = (a * seed + c) % m;
        return (int) seed % 1000;
    }

    static void printMatrix(int[][] arr) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%3d ", arr[i][j]);
            }
            System.out.println();
        }
    }

    static int findMin(int[][] arr) {
        int min = 1000;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                min = min > arr[i][j] ? arr[i][j] : min;
            }
        }
        assert min != 1000;
        return min;
    }

    static int findMax(int[][] arr) {
        int max = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                max = max < arr[i][j] ? arr[i][j] : max;
            }
        }
        assert max != 0;
        return max;
    }

    static double findAvg(int[][] arr) {
        double avg;
        int sum = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sum += arr[i][j];
            }
        }
        avg = (double) sum / (SIZE * SIZE);
        assert (avg / ((findMin(arr) + findMax(arr))) / 2) < 2;
        return avg;
    }
}