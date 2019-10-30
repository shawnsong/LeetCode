package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q489_RobotRoomCleaner {

    public void cleanRoom(Robot robot) {
        backtrack(robot, new HashSet<>(), 0, 0, 0);
    }

    void backtrack(Robot robot, Set<String> visited, int rowIdx, int colIdx, int dir) {
        if (!visited.add(rowIdx + "-" + colIdx)) return;

        robot.clean();
        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                int nextRow = rowIdx;
                int nextCol = colIdx;
                if (dir == 0) {
                    nextRow++;
                } else if (dir == 90) {
                    nextCol++;
                } else if (dir == 180) {
                    nextRow--;
                } else {
                    nextCol--;
                }
                backtrack(robot, visited, nextRow, nextCol, dir);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnRight();
            dir = dir + 90;
            dir = dir % 360;
        }
    }
}

interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();

    void turnRight();

    // Clean the current cell.
    void clean();
}