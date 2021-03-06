package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class Q207_CourseScheduleTest {

    @Test
    public void canFinishBfs() {
        Q207_CourseSchedule test = new Q207_CourseSchedule();
        int[][] courses = {
            {1, 0},
            {2, 0},
            {2, 1},
            {3, 2},
            {4, 3},
            {4, 2},
            {4, 1},
            {4, 0}
        };
        assertTrue(test.canFinishBfs(5, courses));
    }

}
