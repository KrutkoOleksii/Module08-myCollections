package myCollections;

class Node<T> {
    Node<T> prev;
    T elem;
    Node<T> next;

    public Node(Node<T> prev, T elem , Node<T> next){
        this.prev = prev;
        this.elem = elem;
        this.next = next;
    }

}


