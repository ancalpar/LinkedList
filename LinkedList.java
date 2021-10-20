public class LinkedList<E> {
    Node<E> head;
    Node<E> tail;
    int size = 0;

    public void insert (E data) {
        Node<E> node = new Node<>(data);

        if (head == null){
            head = node;
        }
        else{
            tail.next=node;
        }
        tail=node;
        size++;
    }

    public void insert (E data, int index) {
        Node<E> node = head;

        // Step to find node in previous index
        for (int i = 0; i < index-1; i++) {
            node=node.next;
        }

        Node<E> newNode = new Node<>(data);
        newNode.next = node.next;
        node.next = newNode;
        size++;
    }

    public void delete(int index) {
        Node<E> node = head;

        if (index == 0) {
            head = node.next;
            node.next = null;
        }
        else if (0<index && index < size) {
            // Step to find node in previous index
            for (int i = 0; i < index-1; i++) {
                node = node.next;
            }

            if (size-1 == index) {
                node.next = null;
            }
            else {
                Node<E> deletedNode = node.next;
                node.next=node.next.next;
            }
        }
        else {
            throw new RuntimeException();
        }

    }
    public String toString() {
        if (head == null)
            return "[]";
        Node<E> node = head;

        StringBuilder elements = new StringBuilder("[");
        elements.append(node.data).append(node.next != null ? "," : "");
        while (node.next != null) {
            node = node.next;
            elements.append(node.data).append(node.next != null ? "," : "");
        }
        elements.append("]");

        return elements.toString();
    }
}
