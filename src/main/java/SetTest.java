import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetTest {
    Set<String> set;
    @BeforeAll
    public void setUp() {
        set = new Set<>();
    }

    @Test
    public void testAddItem() {
        assertTrue(set.addItem("3"));
        assertFalse(set.addItem("3"));
        assertEquals(1, set.returnNumberOfItem());
    }

    @Test
    public void testSearch() {
        set.addItem("3");

        Node<String> node = set.search("3");

        assertEquals(node, set.search("3"));
        assertEquals("3", set.search("3").getItem());
        assertNull(set.search("5"));
    }

    @Test
    public void testRemove() {
        set.addItem("3");
        assertTrue(set.remove("3")); //testing removing the head
        assertEquals(0, set.returnNumberOfItem());
        assertFalse(set.remove("5")); //testing removing an item not in the list
        set.addItem("4");
        set.addItem("3");
        set.addItem("2");
        set.addItem("1");
        assertTrue(set.remove("4")); //testing removing the last item
        assertTrue(set.remove("2")); //testing removing an item in the middle
    }

    @Test
    public void testIntersection() {
        Set<Integer> set1 = new Set<>();
        Set<Integer> set2 = new Set<>();
        set1.addItem(3);
        set2.addItem(4);

        assertEquals(0,set1.intersection(set2).returnNumberOfItem());
        set2.addItem(3);
        assertEquals(1, set1.intersection(set2).returnNumberOfItem());
        assertEquals(3, set1.intersection(set2).search(3).getItem());
    }

    @Test
    public void testUnion() {
        Set<Integer> set1 = new Set<>();
        Set<Integer> set2 = new Set<>();
        set1.addItem(3);
        set1.addItem(2);
        set1.addItem(1);
        set2.addItem(5);
        assertEquals(0,set1.union(set2).returnNumberOfItem());
        set2.addItem(4);
        set2.addItem(3);
        assertEquals(5,set1.union(set2).returnNumberOfItem());
    }
}
