/**
 * A class implementing a set of items as a singly linked list
 * @param <T> The type of item the set will hold (Integer, String, Char, etc...)
 */
public class Set <T> {
    private Node<T> head;
    private int numberOfItems;

    public Set() {
        head = null;
        numberOfItems = 0;
    }

    public int numberOfItems() {
        return numberOfItems;
    }

    /**
     * Adds an item to the set
     * @param item the item being added
     * @return true if the item was added, false if it wasn't
     */
    public boolean addItem(T item) {
        Node<T> newNode = new Node<>();
        if (!inSet(item)) {
            newNode.setItem(item);
            newNode.setNext(head);
            head = newNode;
            numberOfItems++;
            return true;
        }
        return false;
    }

    /**
     * Searches for a node containing the item in the set
     * @param item the item being searched
     * @return the node containing the item
     */
    public Node<T> search(T item) {
        Node<T> searchNode = head;
        while (searchNode != null) {
            if (searchNode.getItem().equals(item)) return searchNode;
            searchNode = searchNode.getNext();
        }
        return null;
    }

    /**
     * Checks if an item is in the set
     * @param item the item being looked for in the set
     * @return true if the item is in the set, false if it isn't
     */
    public boolean inSet(T item) {
        Node<T> searchNode = head;
        while (searchNode != null) {
            if (searchNode.getItem().equals(item)) return true;
            searchNode = searchNode.getNext();
        }
        return false;
    }

    /**
     * Finds the previous node of the item being searched
     * This is used for deleting a node somewhere in the middle or at the end of the set
     * @param item the item being searched
     * @return the node containing the item
     */
    public Node<T> findPreviousNode(T item) {
        Node<T> previousNode = head;
        while (previousNode.getNext() != null) {
            if (previousNode.getNext().getItem().equals(item)) return previousNode;
            previousNode = previousNode.getNext();
        }
        return null;
    }

    /**
     * Removes an item from the set
     * @param item the item being removed
     * @return true if the item was removed, false if the item wasn't found
     */
    public boolean remove(T item) {
        if (!inSet(item)) return false;

        if (head.getItem().equals(item)) {
            head = head.getNext();
        }
        else {
            Node<T> previousNode = findPreviousNode(item);
            previousNode.setNext(previousNode.getNext().getNext());
        }
        numberOfItems--;
        return true;
    }

    /**
     * Finds the intersection of this and another set
     * @param s2 the second set
     * @return the intersection set of this and s2
     */
    public Set<T> intersection(Set<T> s2) {
        Set<T> intersectionSet = new Set<>();
        Node<T> searchNode1 = head;
        Node<T> searchNode2 = s2.head;

        while (searchNode1 != null) {
            while (searchNode2 != null) {
                if (searchNode1.getItem().equals(searchNode2.getItem())) {
                    intersectionSet.addItem(searchNode1.getItem());
                }
                searchNode2 = searchNode2.getNext();
            }
            searchNode1 = searchNode1.getNext();
            searchNode2 = s2.head;
        }
        return intersectionSet;
    }

    /**
     * Finds the union of this and another set
     * @param s2 the second set
     * @return the union set of this and s2
     */
    public Set<T> union(Set<T> s2) {
        Set<T> unionSet = new Set<>();

        Node<T> node1 = head;
        Node<T> node2 = s2.head;

        while (node1 != null) {
            unionSet.addItem(node1.getItem());
            node1 = node1.getNext();
        }
        while (node2 != null) {
            unionSet.addItem(node2.getItem());
            node2 = node2.getNext();
        }
        return unionSet;
    }

    /**
     * Overrides toString from Object
     * @return a string listing all items in the set
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        Node<T> node = head;
        while (node != null) {
            string.append(node.getItem()).append(" ");
            node = node.getNext();
        }
        return string.toString();
    }
}
