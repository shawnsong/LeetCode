package leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q0741_CherryPickupTest {

  Q0741_CherryPickup test = new Q0741_CherryPickup();

  @Test
  void cherryPickup() {
    assertEquals(0, test.cherryPickup(new int[][] {
            {1, 1,-1, 1, 1},
            {1, 1, 1, 1, 1},
            {-1,1, 1,-1,-1},
            {0, 1, 1,-1, 0},
            {1, 0, -1,1, 0}
        }
    ));

    assertEquals(11, test.cherryPickup(new int[][]{
        {1,1,1,0,0},
        {0,0,1,0,1},
        {1,0,1,0,0},
        {0,0,1,0,0},
        {0,0,1,1,1}
    }));
  }
}