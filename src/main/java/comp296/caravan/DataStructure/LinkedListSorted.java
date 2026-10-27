package comp296.caravan.DataStructure;

//Some more functionality is needed for this class to fulfill all requirements, but this is a start.
public class LinkedListSorted<T extends Comparable<T>> extends LinkedList<T> {

    public LinkedListSorted() {
        head = null;
        tail = null;
        numElements = 0;
        current = null;
    }
    @Override public void add(T element) {
        LinkedNode<T> navNext = head;
        LinkedNode<T> navPrev = null;

        while(navNext!=null) {
            if(navNext.getData().compareTo(element)<0) {
                navPrev = navNext;
                navNext = navNext.getNext();
            }else{
                break;
            }
        }
        LinkedNode<T> newNode = new LinkedNode<T>(element);
        if(numElements==0) { //List is empty.
            head = newNode;
            tail = newNode;
        }else if(navPrev==null) { //Insert as head.
            head = newNode;
            newNode.setNext(navNext);
            navNext.setPrev(newNode);
        }else if(navNext==null) { //Insert as tail.
            tail = newNode;
            newNode.setPrev(navPrev);
            navPrev.setNext(newNode);
        }else{ //Insert in the middle.
            navPrev.setNext(newNode);
            newNode.setPrev(navPrev);
            newNode.setNext(navNext);
            navNext.setPrev(newNode);
        }
        numElements++;
    }
//Test program:
    public static void main(String[] args) {
        LinkedListSorted<Integer> list = new LinkedListSorted<Integer>();

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