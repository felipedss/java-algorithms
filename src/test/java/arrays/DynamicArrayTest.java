package arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.felipedss.algorithms.arrays.DynamicArray;
import org.junit.jupiter.api.Test;

class DynamicArrayTest {


    @Test
    void isEmptyShouldReturnTrueForEmptyArray() {
        DynamicArray dynamicArray = new DynamicArray();
        assertTrue(dynamicArray.isEmpty());
    }

    @Test
    void getSizeShouldReturnZeroForEmptyArray() {
        DynamicArray dynamicArray = new DynamicArray();
        assertEquals(0, dynamicArray.getSize());
    }

}
