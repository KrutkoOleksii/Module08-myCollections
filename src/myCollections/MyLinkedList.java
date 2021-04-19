package myCollections;

public class MyLinkedList<T> extends MyNodeList<T> {

    //возвращает элемент под индексом
    public T get(int index) {
        int ind = 0;
        Node<T> node = getFirst();
        while (node != getLast()){
            if(ind == index){
                return node.elem;
            }
            ind++;
            node = node.next;
        }
        return null;
    }
}
