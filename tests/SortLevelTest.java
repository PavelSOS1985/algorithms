import static sortArrays.SortLevel.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SortLevelTest {
    int[] array;

    @BeforeEach
    void setUp() {
        array = new int[]{7,6,5,4,3,2,1};
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
        assertArrayEquals(new int[]{7,1,5,4,3,2,6}, array);
        InsertionSortStep(array, 4, 2);
        assertArrayEquals(new int[]{7,1,5,4,3,2,6}, array);

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
        assertEquals(0, ArrayChunk(new int[]{1,6,3,0,2}));
        /*assertEquals(3, ArrayChunk(new int[]{1,2,3,4,5,6}));
        assertEquals(3, ArrayChunk(new int[]{6,5,4,3,2,1}));
        assertEquals(1, ArrayChunk(new int[]{6,5,7}));*/
    }
}