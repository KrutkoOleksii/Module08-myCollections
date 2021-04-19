package myCollections;

public class MyLinkedList<T> implements IList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size=0;

    public MyLinkedList() {
        size = 0;
    }

    @Override
    public void add(T value) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(last, value,null);
        if (first == null){
            first = newNode;
            last = newNode;
        }
        last.next = newNode;
        last = newNode;
        size++;
    }

    @Override
    public boolean remove(int index) {
        int ind = 0;
        Node<T> node = first;
        while (node != last){
            if(ind == index){
                node.next.prev = node.prev;
                node.prev.next = node.next;
                size--;
                return true;
            }
            ind++;
            node = node.next;
        }
        return false;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        int ind = 0;
        Node<T> node = first;
        while (node != last){
            if(ind == index){
                return node.elem;
            }
            ind++;
            node = node.next;
        }
        return null;
    }

//    private static class Node<T> {
//        Node<T> prev;
//        T elem;
//        Node<T> next;
//
//        public Node(Node<T> prev, T elem , Node<T> next){
//            this.prev = prev;
//            this.elem = elem;
//            this.next = next;
//        }
//
//    }

    @Override
    public String toString() {
        if(size == 0){
            return "[]";
        }
        String str = "[";
        Node<T> node = first;
        while (node != last){
            str = str + node.elem + ", ";
            node = node.next;
        }
        str = str + node.elem + "]";
        return str;
    }
}
