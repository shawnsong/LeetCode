package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q0149_MaxPointsOnALine {

  public int maxPoints(int[][] points) {
    if (points == null) {
      return 0;
    }

    int res = 0;
    for (int i = 0; i < points.length; i++) {
      int max = 0;
      Map<String, Integer> map = new HashMap<>();
      int dup = 0;
      for (int j = i + 1; j < points.length; j++) {
        int deltaX = points[j][0] - points[i][0];
        int deltaY = points[j][1] - points[i][1];
        if (deltaX == 0 && deltaY == 0) {
          dup++;
          continue;
        }
        int gcd = getGcd(deltaX, deltaY);
        int dx = deltaX / gcd;
        int dy = deltaY / gcd;
        String key = dx + "-" + dy;
        map.put(key, map.getOrDefault(key, 0) + 1);
        max = Math.max(max, map.get(key));
      }
      res = Math.max(res, max + dup + 1);
    }
    return res;
  }

  int getGcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return getGcd(b, a % b);
  }
}
