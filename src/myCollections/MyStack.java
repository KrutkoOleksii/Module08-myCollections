package myCollections;

public class MyStack<T> implements IMyQueue <T>{

    private Node<T> first;
    private Node<T> last;
    private int size=0;

    //добавляет элемент в конец
    public void push(T value){
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
    public void add(T value) {
        push(value);
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

    //возвращает размер коллекции
    @Override
    public int size() {
        return size;
    }

    //возвращает последний элемент в стеке (LIFO)
    @Override
    public T peek() {
        return last.elem;
    }

    //возвращает последний элемент в стеке и удаляет его из коллекции
    public T pop() {
        T el = last.elem;
        last = last.prev;
        last.next = null;
        size--;
        return el;
    }

    @Override
    public T poll() {
        return null;
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
