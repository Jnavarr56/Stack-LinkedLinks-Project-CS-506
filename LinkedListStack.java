public class LinkedListStack {
    private Node head = null;
    

    public LinkedListStack() { }

    public boolean empty() {
        return head == null ? true : false;
    }

    // Add new Node to end of list.
    public void push(Node next) {
        if (empty()) {
            head = next;
        }
        else {
            Node trav = head;
            while (trav.getNext() != null) {
                trav = trav.getNext();
            }
            trav.setNext(next);
        }
    }

    // Remove last node from stack and return.
    public Node pop() throws Exception {
        if (empty()) {
            throw new Exception("EXCEPTION: CANNOT POP BECAUSE STACK IS EMPTY");
        }
        else if (head.getNext() == null) {
            Node returnVal = head;
            head = null;
            return returnVal;
        }
        else {
            Node trav = head;
            Node prev = null;
            while (trav.getNext() != null) {
                prev = trav;
                trav = trav.getNext();
            }
            Node returnVal = trav;
            prev.clearNext();
            return returnVal;
        }
    }

    public Node peak() throws Exception {
        if (empty()) {
            throw new Exception("EXCEPTION: NO ITEMS IN STACK");
        }
        return head;
    }



    public int search(String searchData) {
        if (empty()) {
            return -1;
        }
        else {
            int index = 0;
            Node trav = head;
            if (searchData.equals(trav.getData())) {
                return index;
            }
            else {
                while (trav.getNext() != null) {
                    trav = trav.getNext();
                    index++; 
                    if (searchData.equals(trav.getData())) {
                        return index;
                    } 
                }
            }
            return -1;
        }
    }

    public void printList() {
        if (empty()) {
            System.out.println("STACK EMPTY");
        }
        else {
            int index = 0;
            Node trav = head;
            while (trav.getNext() != null) {
                System.out.printf("NODE INDEX: %d NODE DATA: %s\n", index, trav.getData());
                index++;
                trav = trav.getNext();
            }
            System.out.printf("NODE INDEX: %d NODE DATA: %s\n", index, trav.getData());
        }
    }

}