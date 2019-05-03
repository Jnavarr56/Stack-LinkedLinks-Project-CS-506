public class LinkedListStack {

    private Node head = null;
    private boolean hasMaxSize = false;
    private int maxSize;
    
    public LinkedListStack() { }

    public boolean empty() {
        return head == null ? true : false;
    }

    // Add new Node to end of list.
    public void push(Node next) throws Exception {
        if (empty()) {
            head = next;
        }
        else {
            if (hasMaxSize && maxSize == getSize())  {
                throw new Exception("STACK SIZE EXCEEDED");
            }
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

    public int getSize() {
        if (empty()) {
            return 0;
        }
        else {
            int count = 1;
            Node trav = head;
            while (trav.getNext() != null) {
                trav = trav.getNext();
                count++;
            }
            return count;
        }
    }

    public void setMaxSize(int maxSize) {
        hasMaxSize = true;
        this.maxSize = maxSize;
    }

}