public class LinkedList {
    private Node first;

    public LinkedList() {
        first = null;
    }

    public Node getfirst(){
        return first;
    }
    public boolean isEmpty() {
        if (first == null) return true;
        else return false;
    }

    public void Add(Object value) {
        Node temp = new Node();
        temp.setValue(value);
        if(isEmpty()) {
            first = temp;
        }
        else{
            temp.setNext(first);
            first = temp;
        }
    }
    public void deleteEl() {
        Node node = first;
        if (node.getNext() == null) {
             first = null;
        }
        else first = node.getNext();
    }

    public void show() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }
}
