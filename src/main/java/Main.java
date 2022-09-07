public class Main {
    public static void main(String[] args) {
        Set set1 = new Set();
        System.out.println(set1.returnNumberOfItem());
        set1.addItem("3");
        set1.addItem("2");
        set1.addItem("1");

        System.out.println(set1);

        Set set2 = new Set();
        set2.addItem("4");
        set2.addItem("4");
        set2.addItem("3");
        set2.addItem("1");

        System.out.println(set2);

        Set unionSet = set1.unionOf(set2);
        System.out.println(unionSet);
    }
}
