package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q490_TheMazeTest {

    Q490_TheMaze test = new Q490_TheMaze();

    @Test
    void hasPath() {
        int[][] maze = {
            {0,0,1,0,0},
            {0,0,0,0,0},
            {0,0,0,1,0},
            {1,1,0,1,1},
            {0,0,0,0,0}
        };
        int[] start = {0,4} ;
        int[] end = {4,4};

        test.hasPath(maze, start,end);

        String data = "#,1,,";
        String[] vals = data.split(",");
        System.out.println(vals.length);
    }
}