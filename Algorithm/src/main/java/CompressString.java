/**
 * Created by rahul on 1/31/17.
 */
public class CompressString {
    static String input = "aabcccccaaa";
    //Expected output: a2b1c5a3

    public static void main(String[] args) {
        char[] input = CompressString.input.toCharArray();
        char[] output = new char[input.length];
        char last = input[0];
        int count = 1;
        int outIndex = 0;
        for (int i = 1; i < input.length; i++) {
            if (input[i] == last)
                count++;
            else {
                output[outIndex] = last;
                outIndex++;
                char[] countAsChar = String.valueOf(count).toCharArray();
                for (char c : countAsChar) {
                    output[outIndex] = c;
                    outIndex++;
                }
                last = input[i];
                count = 1;
            }
        }
        output[outIndex] = last;
        outIndex++;
        char[] countAsChar = String.valueOf(count).toCharArray();
        for (char c : countAsChar) {
            output[outIndex] = c;
            outIndex++;
        }
        char[] finalOutput = new char[outIndex];
        System.out.println(output);
    }
}
