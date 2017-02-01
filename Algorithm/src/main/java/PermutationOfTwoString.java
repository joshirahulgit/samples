/**
 * Created by rahul on 1/31/17.
 */
public class PermutationOfTwoString {

    private static boolean isPermutation(char[] S1, char[] S2) {
        if (S1.length != S2.length) {
            return false;
        }
        int[] chars = new int[128];
        for (char c : S1) {
            chars[c] = chars[c] + 1;
        }
        for (char c : S2) {
            chars[c] = chars[c] - 1;
        }
        for (int i : chars) {
            if (i != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPermutation("dog".toCharArray(), "god".toCharArray()));
        System.out.println(isPermutation("dog".toCharArray(), "good".toCharArray()));
    }
}
