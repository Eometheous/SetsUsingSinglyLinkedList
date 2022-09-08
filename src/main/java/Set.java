public class Set <T> {
    private Node<T> head;
    private int numberOfItems;

    public Set() {
        head = null;
        numberOfItems = 0;
    }

    public int returnNumberOfItem() {
        return numberOfItems;
    }

    public boolean addItem(T item) {
        Node<T> newNode = new Node<>();
        if (search(item) == null) {
            newNode.setItem(item);
            newNode.setNext(head);
            head = newNode;
            numberOfItems++;
            return true;
        }
        return false;
    }

    public Node<T> search(T item) {
        Node<T> searchNode = head;
        while (searchNode != null) {
            if (searchNode.getItem().equals(item)) return searchNode;
            searchNode = searchNode.getNext();
        }
        return null;
    }

    public Node<T> findPreviousNode(T item) {
        Node<T> previousNode = head;
        while (previousNode.getNext() != null) {
            if (previousNode.getNext().getItem().equals(item)) return previousNode;
            previousNode = previousNode.getNext();
        }
        return null;
    }

    public boolean remove(T item) {
        if (head.getItem().equals(item)) {
            head = head.getNext();
            numberOfItems--;
            return true;
        }
        Node<T> node = search(item);
        if (node == null) return false;
        Node<T> previousNode = findPreviousNode(item);
        previousNode.setNext(node.getNext());
        numberOfItems--;
        return true;
    }

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

    public Set<T> union(Set<T> s2) {
        if (!hasElementsInCommon(s2)) return null;
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

    public boolean hasElementsInCommon(Set<T> s2) {
        Node<T> searchNode1 = head;
        Node<T> searchNode2 = s2.head;
        while (searchNode1 != null) {
            while (searchNode2 != null) {
                if (searchNode1.getItem().equals(searchNode2.getItem())) {
                    return true;
                }
                searchNode2 = searchNode2.getNext();
            }
            searchNode1 = searchNode1.getNext();
            searchNode2 = s2.head;
        }
        return false;
    }

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
