package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 *
 * All DNA is composed of a series of nucleotides abbreviated as
 * A, C, G, and T, for example: "ACGAATTCCG". When studying DNA,
 * it is sometimes useful to identify repeated sequences within
 * the DNA.
 * Write a function to find all the 10-letter-long sequences
 * (substrings) that occur more than once in a DNA molecule.
 *
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class RepeatedDNASequences_187 {
    /*
     * Encode A, T, C, G to other format to save space.
     * Since 4^10 = 1048576 < 2^32
     * Can use Integer bit:
     * 0 (00): A
     * 1 (01): T
     * 2 (10): C
     * 3 (11): G
     */
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null) return null;
        HashSet<String> result = new HashSet<String>();
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < s.length() - 9; ++i) {
            String seq = s.substring(i, i + 10);
            int code = encode(seq);
            if (!set.contains(code)) {
                set.add(code);
            } else {
                result.add(seq);
            }
        }
        return new ArrayList<String>(result);
    }

    private int encode(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            result <<= 2;
            result |= code(s.charAt(i));
        }
        return result;
    }

    private int code(char ch) {
        switch (ch) {
            case 'A': return 0;
            case 'T': return 1;
            case 'C': return 2;
            case 'G': return 3;
            default: return -1;
        }
    }
}
