package comp296.caravan.DataStructure;

public class LinkedNode<T> {
    private T data=null;
    private LinkedNode<T> next=null;
    private LinkedNode<T> prev=null;

    public LinkedNode(T data) {
        this.data=data;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public LinkedNode<T> getNext() {
        return next;
    }
    public LinkedNode<T> getPrev() {
        return prev;
    }
    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }
    public void setPrev(LinkedNode<T> prev) {
        this.prev = prev;
    }
}