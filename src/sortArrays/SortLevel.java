package sortArrays;

// JAVA 8
public class SortLevel {

    // one step in selection sort
    public static void SelectionSortStep(int[] array, int i) {
        if (i >= array.length || i < 0) return;
        int min = array[i], tempJ = i, tempI;
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] < min) {
                min = array[j];
                tempJ = j;
            }
        }
        tempI = array[i];
        array[i] = min;
        array[tempJ] = tempI;
    }

    // one step in bubble sort, return false if the exchange was
    public static boolean BubbleSortStep(int[] array) {
        boolean result = true;
        int tempI;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < array[i]) {
                tempI = array[i];
                array[i] = array[i + 1];
                array[i + 1] = tempI;
                result = false;
            }
        }
        return result;
    }

    // one step in sort by insertion
    public static void InsertionSortStep(int[] array, int step, int i) {
        if (step < 1 || i < 0 || i > array.length) return;
        int tempI = array[i];
        step = step + i; // index for change
        while (step > array.length - 1) {
            step = step - array.length;
        }
        array[i] = array[step];
        array[step] = tempI;
    }
}