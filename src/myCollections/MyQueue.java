package myCollections;

public class MyQueue<T> implements IMyQueue<T>{

    private Node<T> first;
    private Node<T> last;
    private int size=0;

    public MyQueue() {
        this.size = 0;
    }

    //добавляет элемент в конец
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

    //удаляет элемент под индексом
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

    //очищает коллекцию
    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    //очищает коллекцию
    @Override
    public int size() {
        return size;
    }

    //возвращает первый элемент в очереди (FIFO)
    @Override
    public T peek(){
        return first.elem;
    }

    //возвращает первый элемент в очереди и удаляет его из коллекции
    @Override
    public T poll(){
        T el = first.elem;
        first = first.next;
        first.prev = null;
        size--;
        return el;
    }

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
