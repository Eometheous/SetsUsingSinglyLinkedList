import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetTest {
    static Set<Integer> set;
    double start, end;

    @BeforeEach
    public void setUp() {
        set = new Set<>();
    }

    @Test
    public void testAddItem() {
        start = System.nanoTime();
        assertTrue(set.addItem(3));
        assertFalse(set.addItem(3));
        assertEquals(1, set.numberOfItems());
        end = System.nanoTime();
        System.out.printf("Execution time of testAddItem: %.2f ms\n", (end - start)/1000000);
    }
    @Test
    public void testInSet() {
        start = System.nanoTime();
        set.addItem(3);
        assertTrue(set.inSet(3));
        assertFalse(set.inSet(5));
        end = System.nanoTime();
        System.out.printf("Execution time of testInSet: %.2f ms\n", (end - start)/1000000);
    }

    @Test
    public void testSearch() {
        start = System.nanoTime();
        set.addItem(3);

        Node<Integer> node = set.search(3);

        assertEquals(node, set.search(3));
        assertEquals(3, set.search(3).getItem());
        assertNull(set.search(5));
        end = System.nanoTime();
        System.out.printf("Execution time of testSearch: %.2f ms\n", (end - start)/1000000);
    }

    @Test
    public void testRemove() {
        start = System.nanoTime();
        set.addItem(3);
        assertTrue(set.remove(3)); //testing removing the head
        assertEquals(0, set.numberOfItems());
        assertFalse(set.remove(3)); //testing removing an item not in the list
        set.addItem(4);
        set.addItem(3);
        set.addItem(2);
        set.addItem(1);
        assertTrue(set.remove(3)); //testing removing the last item
        assertTrue(set.remove(2)); //testing removing an item in the middle
        end = System.nanoTime();
        System.out.printf("Execution time of testRemove: %.2f ms\n", (end - start)/1000000);
    }

    @Test
    public void testIntersection() {
        start = System.nanoTime();
        Set<Integer> set1 = new Set<>();
        Set<Integer> set2 = new Set<>();
        set1.addItem(3);
        set2.addItem(4);

        assertEquals(0,set1.intersection(set2).numberOfItems());
        set2.addItem(3);
        assertEquals(1, set1.intersection(set2).numberOfItems());
        assertEquals(3, set1.intersection(set2).search(3).getItem());
        end = System.nanoTime();
        System.out.printf("Execution time of testIntersection: %.2f ms\n", (end - start)/1000000);
    }

    @Test
    public void testUnion() {
        start = System.nanoTime();
        Set<Integer> set1 = new Set<>();
        Set<Integer> set2 = new Set<>();
        set1.addItem(3);
        set1.addItem(2);
        set1.addItem(1);
        set2.addItem(5);
        assertEquals(4,set1.union(set2).numberOfItems());
        set2.addItem(4);
        set2.addItem(3);
        assertEquals(5,set1.union(set2).numberOfItems());
        end = System.nanoTime();
        System.out.printf("Execution time of testUnion: %.2f ms\n", (end - start)/1000000);
    }

    @Test
    public void test1000Items() {
        for (int i = 0; i < 999; i++) {
            set.addItem(i);
        }
        start = System.nanoTime();
        set.addItem(999);
        end = System.nanoTime();
        System.out.printf("Time to add 1000th item: %.4f ms \n", (end - start)/1000000);

        start = System.nanoTime();
        set.inSet(0);
        end = System.nanoTime();
        System.out.printf("Time to see if last item is in the set: %.4f ms \n", (end - start)/1000000);

        start = System.nanoTime();
        set.search(0);
        end = System.nanoTime();
        System.out.printf("Time to search for last item: %.4f ms \n", (end - start)/1000000);

        start = System.nanoTime();
        set.remove(1000);
        end = System.nanoTime();
        System.out.printf("Time to try and remove 1000: %.4f ms \n", (end - start)/1000000);

        Set<Integer> set2 = set;
        start = System.nanoTime();
        set.intersection(set2);
        end = System.nanoTime();
        System.out.printf("Time to create intersection: %.4f ms \n", (end - start)/1000000);

        start = System.nanoTime();
        set.union(set2);
        end = System.nanoTime();
        System.out.printf("Time to create union: %.4f ms \n", (end - start)/1000000);
    }
    @Test
    public void test2500Items() {
        for (int i = 0; i < 2499; i++) {
            set.addItem(i);
        }
        start = System.nanoTime();
        set.addItem(2499);
        end = System.nanoTime();
        System.out.printf("Time to add 2500th item: %.4f ms \n", (end - start)/1000000);

        start = System.nanoTime();
        set.inSet(0);
        end = System.nanoTime();
        System.out.printf("Time to see if last item is in the set: %.4f ms \n", (end - start)/1000000);

        start = System.nanoTime();
        set.search(0);
        end = System.nanoTime();
        System.out.printf("Time to search for last item: %.4f ms \n", (end - start)/1000000);

        start = System.nanoTime();
        set.remove(2500);
        end = System.nanoTime();
        System.out.printf("Time to try and remove 2500: %.4f ms \n", (end - start)/1000000);

        Set<Integer> set2 = set;
        start = System.nanoTime();
        set.intersection(set2);
        end = System.nanoTime();
        System.out.printf("Time to create intersection: %.4f ms \n", (end - start)/1000000);

        start = System.nanoTime();
        set.union(set2);
        end = System.nanoTime();
        System.out.printf("Time to create union: %.4f ms \n", (end - start)/1000000);
    }

    @Test
    public void test5000Items() {
        for (int i = 0; i < 4999; i++) {
            set.addItem(i);
        }
        start = System.nanoTime();
        set.addItem(4999);
        end = System.nanoTime();
        System.out.printf("Time to add 5000th item: %.4f ms \n", (end - start)/1000000);

        start = System.nanoTime();
        set.inSet(0);
        end = System.nanoTime();
        System.out.printf("Time to see if last item is in the set: %.4f ms \n", (end - start)/1000000);

        start = System.nanoTime();
        set.search(0);
        end = System.nanoTime();
        System.out.printf("Time to search for last item: %.4f ms \n", (end - start)/1000000);

        start = System.nanoTime();
        set.remove(5000);
        end = System.nanoTime();
        System.out.printf("Time to try and remove 5000: %.4f ms \n", (end - start)/1000000);

        Set<Integer> set2 = set;
        start = System.nanoTime();
        set.intersection(set2);
        end = System.nanoTime();
        System.out.printf("Time to create intersection: %.4f ms \n", (end - start)/1000000);

        start = System.nanoTime();
        set.union(set2);
        end = System.nanoTime();
        System.out.printf("Time to create union: %.4f ms \n", (end - start)/1000000);
    }

    @Test
    public void test7500Items() {
        for (int i = 0; i < 7499; i++) {
            set.addItem(i);
        }
        start = System.nanoTime();
        set.addItem(7499);
        end = System.nanoTime();
        System.out.printf("Time to add 7500th item: %.4f ms \n", (end - start)/1000000);

        start = System.nanoTime();
        set.inSet(0);
        end = System.nanoTime();
        System.out.printf("Time to see if last item is in the set: %.4f ms\n", (end - start)/1000000);

        start = System.nanoTime();
        set.search(0);
        end = System.nanoTime();
        System.out.printf("Time to search for last item: %.4f ms \n", (end - start)/1000000);

        start = System.nanoTime();
        set.remove(7500);
        end = System.nanoTime();
        System.out.printf("Time to try and remove 7500: %.4f ms \n", (end - start)/1000000);

        Set<Integer> set2 = set;
        start = System.nanoTime();
        set.intersection(set2);
        end = System.nanoTime();
        System.out.printf("Time to create intersection: %.4f ms \n", (end - start)/1000000);

        start = System.nanoTime();
        set.union(set2);
        end = System.nanoTime();
        System.out.printf("Time to create union: %.4f ms \n", (end - start)/1000000);
    }

    @Test
    public void test10000Items() {
        for (int i = 0; i < 9999; i++) {
            set.addItem(i);
        }
        start = System.nanoTime();
        set.addItem(9999);
        end = System.nanoTime();
        System.out.printf("Time to add 10000th item: %.4f ms \n", (end - start)/1000000);

        start = System.nanoTime();
        set.inSet(0);
        end = System.nanoTime();
        System.out.printf("Time to see if last item is in the set: %.4f ms\n", (end - start)/1000000);

        start = System.nanoTime();
        set.search(0);
        end = System.nanoTime();
        System.out.printf("Time to search for last item: %.4f ms \n", (end - start)/1000000);

        start = System.nanoTime();
        set.remove(10000);
        end = System.nanoTime();
        System.out.printf("Time to try and remove 10000: %.4f ms \n", (end - start)/1000000);

        Set<Integer> set2 = set;
        start = System.nanoTime();
        set.intersection(set2);
        end = System.nanoTime();
        System.out.printf("Time to create intersection: %.4f ms \n", (end - start)/1000000);

        start = System.nanoTime();
        set.union(set2);
        end = System.nanoTime();
        System.out.printf("Time to create union: %.4f ms \n", (end - start)/1000000);
    }
}
