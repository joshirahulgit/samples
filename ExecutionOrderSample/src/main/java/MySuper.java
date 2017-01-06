/**
 * Created by rahul on 1/6/17.
 */
public class MySuper {

    private static String superStaticField = setSuperStaticField();

    private String superField = setSuperField();

    public MySuper() {
        System.out.println("Super Constructor.");
    }

    private static String setSuperStaticField() {
        System.out.println("Super Static Field.");
        return "";
    }

    private String setSuperField() {
        System.out.println("Super Field.");
        return "";
    }

    public String getSuperField() {
        return superField;
    }
}
