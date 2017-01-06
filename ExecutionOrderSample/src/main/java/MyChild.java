/**
 * Created by rahul on 1/6/17.
 */
public class MyChild extends MySuper {

    private static String childStaticField = setChildStaticField();

    private String childField = setChildField();

    public MyChild() {
        System.out.println("Child Constructor.");
    }

    private static String setChildStaticField() {
        System.out.println("Child Static Field.");
        return "";
    }

    private static String setChildField() {
        System.out.println("Child Field.");
        return "";
    }

    public String getChildField() {
        return childField;
    }
}
