package algorithms.hashtable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class IceCreamPriorTest {

    @Test
    void test() {
        assertEquals("2 3", IceCreamParlor.whatFlavours(Arrays.asList(4, 3, 2, 5, 7), 5));
        assertEquals("1 3", IceCreamParlor.whatFlavours(Arrays.asList(7, 2, 5, 4, 11), 12));
        assertEquals("1 2", IceCreamParlor.whatFlavours(Arrays.asList(2, 2, 4, 3), 4));
    }

}
