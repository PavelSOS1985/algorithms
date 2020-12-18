import static sortArrays.SortLevel.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortLevelTest {
    int[] array;

    @BeforeEach
    void setUp() {
        array = new int[]{4, 5, 3, 2};
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
        InsertionSortStep(array, 1, 1);
        assertArrayEquals(new int[]{4, 3, 5, 2}, array);
        InsertionSortStep(array, 1, 0);
        assertArrayEquals(new int[]{3, 4, 5, 2}, array);
        InsertionSortStep(array, 1, 3);
        assertArrayEquals(new int[]{3, 4, 5, 2}, array);
        InsertionSortStep(array, 5, 0);
        assertArrayEquals(new int[]{3, 4, 5, 2}, array);
        InsertionSortStep(array, 3, 0);
        assertArrayEquals(new int[]{2, 4, 5, 3}, array);
    }
}