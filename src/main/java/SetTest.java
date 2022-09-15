import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetTest {
    static Set<String> set;
    double start, end;

    @BeforeAll
    public static void setUp() {
        set = new Set<>();
    }

    @Test
    public void testAddItem() {
        start = System.currentTimeMillis();
        assertTrue(set.addItem("3"));
        assertFalse(set.addItem("3"));
        assertEquals(1, set.numberOfItems());
        end = System.currentTimeMillis();
        System.out.println("Execution time of testAddItem: " + (end - start));
    }
    @Test
    public void testInSet() {
        start = System.currentTimeMillis();
        set.addItem("3");
        assertTrue(set.inSet("3"));
        assertFalse(set.inSet("5"));
        end = System.currentTimeMillis();
        System.out.println("Execution time of testInSet: " + (end - start));
    }

    @Test
    public void testSearch() {
        start = System.currentTimeMillis();
        set.addItem("3");

        Node<String> node = set.search("3");

        assertEquals(node, set.search("3"));
        assertEquals("3", set.search("3").getItem());
        assertNull(set.search("5"));
        end = System.currentTimeMillis();
        System.out.println("Execution time of testSearch: " + (end - start));
    }

    @Test
    public void testRemove() {
        start = System.currentTimeMillis();
        set.addItem("3");
        assertTrue(set.remove("3")); //testing removing the head
        assertEquals(0, set.numberOfItems());
        assertFalse(set.remove("5")); //testing removing an item not in the list
        set.addItem("4");
        set.addItem("3");
        set.addItem("2");
        set.addItem("1");
        assertTrue(set.remove("4")); //testing removing the last item
        assertTrue(set.remove("2")); //testing removing an item in the middle
        end = System.currentTimeMillis();
        System.out.println("Execution time of testRemove: " + (end - start));
    }

    @Test
    public void testIntersection() {
        start = System.currentTimeMillis();
        Set<Integer> set1 = new Set<>();
        Set<Integer> set2 = new Set<>();
        set1.addItem(3);
        set2.addItem(4);

        assertEquals(0,set1.intersection(set2).numberOfItems());
        set2.addItem(3);
        assertEquals(1, set1.intersection(set2).numberOfItems());
        assertEquals(3, set1.intersection(set2).search(3).getItem());
        end = System.currentTimeMillis();
        System.out.println("Execution time of testIntersection: " + (end - start));
    }

    @Test
    public void testUnion() {
        start = System.currentTimeMillis();
        Set<Integer> set1 = new Set<>();
        Set<Integer> set2 = new Set<>();
        set1.addItem(3);
        set1.addItem(2);
        set1.addItem(1);
        set2.addItem(5);
        assertEquals(0,set1.union(set2).numberOfItems());
        set2.addItem(4);
        set2.addItem(3);
        assertEquals(5,set1.union(set2).numberOfItems());
        end = System.currentTimeMillis();
        System.out.println("Execution time of testUnion: " + (end - start));
    }
}
