import static sortArrays.SortLevel.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortLevelTest {
    int[] array;

    @BeforeEach
    void setUp() {
        array = new int[]{7, 6, 5, 4, 3, 2, 1};
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void selectionSortStep() {
        SelectionSortStep(array, 1);
        assertArrayEquals(new int[]{4, 2, 3, 5}, array);
    }

    @Test
    void bubbleSortStep() {
        assertFalse(BubbleSortStep(array));
    }

    @Test
    void insertionSortStep() {
        InsertionSortStep(array, 5, 1);
        assertArrayEquals(new int[]{7, 1, 5, 4, 3, 2, 6}, array);
        InsertionSortStep(array, 4, 2);
        assertArrayEquals(new int[]{7, 1, 5, 4, 3, 2, 6}, array);

    }

    @Test
    void knuthSequence() {
        assertEquals(0, KnuthSequence(0).size());
        assertEquals(1, KnuthSequence(1).size());
        assertEquals(2, KnuthSequence(13).size());
        assertEquals(3, KnuthSequence(15).size());

    }

    @Test
    void arrayChunk() {

        /*assertEquals(3, ArrayChunk(new int[]{7,1,5,4,3,2,6}));
        assertEquals(3, ArrayChunk(new int[]{7,5,6,4,3,1}));
        assertEquals(0, ArrayChunk(new int[]{}));
        assertEquals(0, ArrayChunk(new int[]{55}));
        assertEquals(2, ArrayChunk(new int[]{1,6,3,4,7}));*/
        // assertEquals(0, ArrayChunk(new int[]{1,6,3,0,2}));
        //assertEquals(3, ArrayChunk(new int[]{1,0,15,31,3,22,7}));
        /*assertEquals(3, ArrayChunk(new int[]{1,2,3,4,5,6}));
        assertEquals(3, ArrayChunk(new int[]{6,5,4,3,2,1}));
        assertEquals(1, ArrayChunk(new int[]{6,5,7}));*/

    }

    @Test
    void quickSort() {
        array = new int[]{1, 0, 15, 31, 3, 22, 7};

        QuickSort(array, 0, 2);
        assertArrayEquals(new int[]{0, 1, 15, 31, 3, 22, 7}, array);

        QuickSort(array, 3, 6);
        assertArrayEquals(new int[]{0, 1, 15, 3, 7, 22, 31}, array);

        QuickSort(array, 0, 6);
        assertArrayEquals(new int[]{0, 1, 3, 7, 15, 22, 31}, array);

    }

    @Test
    void quickSortTailOptimization() {
        array = new int[]{1, 0, 15, 31, 3, 22, 7};
        QuickSortTailOptimization(array, 0, 6);
        assertArrayEquals(new int[]{0, 1, 3, 7, 15, 22, 31}, array);
    }

    @Test
    void kthOrderStatisticsStep() {
        array = new int[]{5,6,7,4,1,2,3};
        ArrayList<Integer> list = KthOrderStatisticsStep(array, 0, 6, 0);
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(0, 2));
        assertArrayEquals(list.toArray(), list2.toArray());

        list = KthOrderStatisticsStep(array, list.get(0), list.get(1), 0);
        list2 = new ArrayList<>(Arrays.asList(0, 0));
        assertArrayEquals(list.toArray(), list2.toArray());
    }
}