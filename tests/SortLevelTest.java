import static sortArrays.SortLevel.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}