/**
 * Created by rahul on 1/31/17.
 */
public class CompareTwoNo {
    public static int compare(int a, int b) {
        return a ^ b;
    }

    public static void main(String[] args) {
        System.out.println(Boolean.parseBoolean(compare(2,2) + ""));
    }
}
