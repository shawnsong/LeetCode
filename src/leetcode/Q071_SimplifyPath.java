package leetcode;

import java.util.ArrayList;

/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

click to show corner cases.
Corner Cases:

    Did you consider the case where path = "/../"?
    In this case, you should return "/".
    Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
    In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class Q071_SimplifyPath {
	public String simplifyPath(String path) {
		if (path == null || path.length() == 0)
			return "/";
		
		String[] paths = path.split("/");
		ArrayList<String> list = new ArrayList();
		
		for (int i = 0; i < paths.length; i++) {
			String dir = paths[i];
			if (dir.equals("") || dir.equals("."))
				continue;
			else if (dir.equals("..")) {
				if (!list.isEmpty()) {
					list.remove(list.size() - 1);
				}
			} else {
				list.add(dir);
			}
		}
		
		if (list.isEmpty())
			return "/";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++)
			sb.append("/").append(list.get(i));
		
		return sb.toString();
	}

}
