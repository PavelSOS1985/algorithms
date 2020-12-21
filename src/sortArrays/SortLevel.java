package sortArrays;

import java.util.ArrayList;
import java.util.Arrays;

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
        if (step < 1 || i < 0 || i >= array.length) return;
        int countIterations = array.length / step;
        for (int k = 0; k < countIterations; k++) {
            for (int j = i; j < array.length - step; j += step) {
                if (array[j] > array[j + step]) {
                    int tempI = array[j];
                    array[j] = array[j + step];
                    array[j + step] = tempI;
                }
            }
        }
    }

    // finds interval sequence (Knuth)
    public static ArrayList<Integer> KnuthSequence(int array_size) {
        ArrayList<Integer> resultList = new ArrayList<>();
        int steps;
        for (int i = 1; i < array_size; i = steps) {
            resultList.add(0, i);
            steps = 3 * i + 1;
        }
        System.out.println(resultList);
        return resultList;
    }
}