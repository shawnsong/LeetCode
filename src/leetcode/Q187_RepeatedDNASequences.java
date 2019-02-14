package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
 When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].

 */
public class Q187_RepeatedDNASequences {
	public static void main(String[] a) {
		Q187_RepeatedDNASequences o = new Q187_RepeatedDNASequences();
		System.out.println(o.findRepeatedDnaSequences("AAAAAAAAAAA"));
	}
	public List<String> findRepeatedDnaSequences(String s) {
		HashSet<String> tmpRes = new HashSet();
		HashSet<String> res = new HashSet();
		for (int i = 0; i <= s.length() - 10; i++) {
			String sub = s.substring(i, i + 10);
			if (tmpRes.contains(sub)) {
				if (!res.contains(sub))
					res.add(sub);
			} else {
				tmpRes.add(sub);
			}
		}
		List<String> list = new LinkedList();
		list.addAll(res);
		return list;
	}
}
