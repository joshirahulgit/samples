/**
 * Created by rahul on 1/31/17.
 */
public class InsertInBlankSpace {
    private static String input = "Mr John Smith    ";
    //Expected output: Mr%20John%20Smith
    private static int stringLength = 13;

    public static void main(String[] args) {
        char[] input = InsertInBlankSpace.input.toCharArray();
        int spaceCounter = 0;
        for (int i = 0; i < stringLength; i++) {
            if (input[i] == ' ') {
                spaceCounter++;
            }
        }
        for (int i = stringLength - 1; i > -1; i--) {
            int shiftSpace = spaceCounter * 2;
            if (input[i] != ' ') {
                input[i + shiftSpace] = input[i];
            } else {
                input[i + shiftSpace - 2] = '%';
                input[i + shiftSpace - 1] = '2';
                input[i + shiftSpace] = '0';
                spaceCounter--;
            }
        }

        System.out.println(input);
    }
}
