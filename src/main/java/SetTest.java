import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetTest {
    Set<String> set = new Set<>();

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
        assertTrue(set.remove("3"));
        assertFalse(set.remove("5"));
        set.addItem("3");
        set.addItem("2");
        assertTrue(set.remove("2"));
        set.addItem("2");
        assertTrue(set.remove("3"));
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

    }
}
