package comp296.caravan.DataStructure;

//Some more functionality is needed for this class to fulfill all requirements, but this is a start.
public class LinkedList<T> {
    protected LinkedNode<T> head;
    protected LinkedNode<T> tail;
    protected int numElements;
    protected LinkedNode<T> current;
    protected LinkedNode<T> location;
    protected boolean found;

    public LinkedList() {
        head = null;
        tail = null;
        numElements = 0;
        current = null;
    }
    public void add(T element) {
        LinkedNode<T> newNode = new LinkedNode<T>(element);
        if(numElements==0) { //List is empty.
            head = newNode;
            tail = newNode;
        }else{ //Insert as tail.
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        numElements++;
    }
    protected void find(T target) {
        location = head;
        found = false;

        while(location!=null) {
            if(location.getData().equals(target)) {
                found = true;
                return;
            }else{
                location = location.getNext();
            }
        }
    }
    public boolean contains(T target) {
        find(target);
        return found;
    }
    public boolean remove(T target) {
        find(target);
        if(found) {
           if(location==head) { //Target is head.
                head = location.getNext();
           }else if(location==tail) { //Target is tail.
                tail = location.getPrev();
           }else{ //Target in the middle.
                location.getPrev().setNext(location.getNext());
                location.getNext().setPrev(location.getPrev());
           }
           numElements--;
        }
        return found;
    }
    public T get(T target) {
        find(target);
        if(found) {
            return location.getData();
        }else{
            return null;
        }
    }
    public void resetHead() {
        current = head;
    }
    public void resetTail() {
        current = tail;
    }
    public T getNext() {
        if(numElements==0) {
            return null;
        }
        T next = current.getData();
        if(current.getNext()==null){
            current = head;
        }else{
            current = current.getNext();
        }
        return next;
    }
    public T getPrev() {
        if(numElements==0) {
            return null;
        }
        T prev = current.getData();
        if(current.getPrev()==null){
            current = tail;
        }else{
            current = current.getPrev();
        }
        return prev;
    }
    public int size() {
        return numElements;
    }
    public String toString() { //Only for debugging purposes.
        location = head;
        String output = "List:\n";

        while(location!=null) {
            output += " " + location.getData().toString() + ".\n";
            location = location.getNext();
        }
        output += "Size: "+size();
        return output;
    }
//Test program:
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int run=0; run<19; run++) {
            list.add((int)(Math.random()*54)+1);
        }
        list.add(42);
        System.out.println("Initial "+list+"\n");

        int its42 = list.get(42);
        System.out.println("Here's 42: "+its42+"\n");

        list.remove(42);
        System.out.println("42 Removed, "+list+"\n");

        list.resetHead();
        System.out.println("First element: "+list.getNext()+"\n");

        list.resetTail();
        System.out.println("Last element: "+list.getPrev()+"\n");
    }
}