package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q011_ContainerWithMostWaterTest {

    Q011_ContainerWithMostWater underTest = new Q011_ContainerWithMostWater();

    @Test
    void maxArea() {
        assertEquals(49, underTest.maxArea(new int[] {1,8,6,2,5,4,8,3,7} ));
    }
}