public class Main {
    public static void main(String[] args) {
        Set<String> set1 = new Set<>();
        System.out.println(set1.returnNumberOfItem());
        set1.addItem("3");
        set1.addItem("2");
        set1.addItem("1");

        System.out.println("Set1: " + set1);

        Set<String> set2 = new Set<>();
        set2.addItem("4");
        if(!set2.addItem("4")) System.out.println("This item is already in the set");
        set2.addItem("3");
        set2.addItem("1");

        if (!set2.remove("5")) System.out.println("Couldn't find that item in the list");

        System.out.println("Set2: " + set2);

        Set<String> unionSet = set1.union(set2);
        Set<String> intersectionSet = set1.intersection(set2);
        System.out.println("Union of S1 and S2: " + unionSet);
        System.out.println("Intersection of S1 and S2: " + intersectionSet);
    }
}
