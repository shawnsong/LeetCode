package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)


 */
public class Q093_RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new LinkedList();
		if (s == null || s.length() < 4)
			return res;
		
		restore(s, res, new ArrayList(), 0);
		return res;
	}
	
	private void restore(String s, List<String> res, ArrayList<Integer> tmp, int count) {
		if (count == 4) {
			if (s.length() != 0)
				return;
			StringBuilder sb = new StringBuilder();
			String prefix = "";
			for (int i = 0; i < tmp.size(); i++) {
				sb.append(prefix).append(tmp.get(i));
				prefix = ".";
			}
			res.add(sb.toString());
			return;
		}
		
		for (int i = 0; i < s.length(); i++) {
			String part = s.substring(0, i + 1);
			if (part.length() > 1 && part.charAt(0) == '0')
				break;
			int ip = Integer.parseInt(part);
			if (ip > 255)
				break;
			tmp.add(ip);
			restore(s.substring(i + 1), res, tmp, count + 1);
			tmp.remove(tmp.size() - 1);
		}
	}
}
