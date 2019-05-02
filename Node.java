public class Node {
    private Node next = null;
    private String data;

    public Node () { }
    public Node (String data) {
        setData(data);
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void clearNext() {
        this.next = null;
    }
}