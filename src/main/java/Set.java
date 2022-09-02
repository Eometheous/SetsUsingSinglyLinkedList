public class Set {
    private Node head;
    private int numberOfItems;

    public Set() {
        head = null;
        numberOfItems = 0;
    }

    public int returnNumberOfItem() {
        return numberOfItems;
    }

    public void addItem(int item) {
        Node newNode = new Node();
        if (search(item) == null) {
            newNode.setItem(item);
            newNode.setNext(head);
            head = newNode;
            numberOfItems++;
        }
    }

    public Node search(int item) {
        Node searchNode = head;
        while (searchNode != null) {
            if (searchNode.getItem() == item) return searchNode;
            searchNode = searchNode.getNext();
        }
        return null;
    }

    public Node findPreviousNode(int item) {
        Node previousNode = head;
        while (previousNode.getNext() != null) {
            if (previousNode.getNext().getItem() == item) return previousNode;
            previousNode = previousNode.getNext();
        }
        return null;
    }

    public boolean remove(int item) {
        if (head.getItem() == item) {
            head = head.getNext();
            numberOfItems--;
            return true;
        }
        Node node = search(item);
        if (node == null) return false;
        Node previousNode = findPreviousNode(item);
        previousNode.setNext(node.getNext());
        numberOfItems--;
        return true;
    }

    public Set unionOf(Set s2) {
        Set unionSet = new Set();
        if (!isUnion(s2)) return null;
        Node node1 = head;
        Node node2 = s2.head;

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

    public boolean isUnion(Set s2) {
        Node searchNode1 = head;
        Node searchNode2 = s2.head;
        while (searchNode1 != null) {
            while (searchNode2 != null) {
                if (searchNode1.getItem() == searchNode2.getItem()) {
                    return true;
                }
                searchNode2 = searchNode2.getNext();
            }
            searchNode1 = searchNode1.getNext();
        }
        return false;
    }

    @Override
    public String toString() {
        String string = "";
        Node node = head;
        while (node != null) {
            string += node.getItem() + " ";
            node = node.getNext();
        }
        return string;
    }
}
