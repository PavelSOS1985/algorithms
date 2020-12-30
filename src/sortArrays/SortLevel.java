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
        if (array_size < 1) return resultList;
        int i = 1;
        do {
            resultList.add(0, i);
            i = 3 * i + 1;
        } while (i < array_size);
        return resultList;
    }

    // algorithm partitioning of the array
    // when no identical elements in the array
    public static int ArrayChunk(int[] M) {
        if (M.length <= 1) return 0;
        int iN, N, i1, i2;
        iN = M.length / 2;
        N = M[iN]; //threshold value
        i1 = 0;
        i2 = M.length - 1;
        while (i1 != i2) {
            while (M[i1] < N) i1++;
            while (M[i2] > N) i2--;
            if (i1 == i2 - 1 && M[i1] > M[i2]) {
                int tempEl = M[i1];
                M[i1] = M[i2];
                M[i2] = tempEl;
                N = M[iN];
                i1 = 0;
                i2 = M.length - 1;
                continue;
            }

            int tempEl1 = M[i1];
            M[i1] = M[i2];
            M[i2] = tempEl1;

            if (M[i1] == N) iN = i1;
            if (M[i2] == N) iN = i2;
        }
        return iN;
    }

    public static void QuickSort(int[] array, int left, int right) {
        if (left >= right || right >= array.length || left < 0) return;
        int N = ArrayChunkForQS(array, left, right);
        QuickSort(array, left, N - 1);
        QuickSort(array, N + 1, right);
    }

    private static int ArrayChunkForQS(int[] M, int left, int right) {
        int length = right - left + 1;
        if (length <= 1) return 0;
        int iN, N, i1, i2;
        iN = left + length / 2;
        N = M[iN]; //threshold value
        i1 = left;
        i2 = right;
        while (i1 != i2) {
            while (M[i1] < N) i1++;
            while (M[i2] > N) i2--;
            if (i1 == i2 - 1 && M[i1] > M[i2]) {
                int tempEl = M[i1];
                M[i1] = M[i2];
                M[i2] = tempEl;
                N = M[iN];
                i1 = left;
                i2 = right;
                continue;
            }
            int tempEl1 = M[i1];
            M[i1] = M[i2];
            M[i2] = tempEl1;
            if (M[i1] == N) iN = i1;
            if (M[i2] == N) iN = i2;
        }
        return iN;
    }
}