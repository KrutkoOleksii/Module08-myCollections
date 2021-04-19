package myCollections;

public abstract class MyNodeList<T> implements IMyQueue<T> {

    private Node<T> first;
    private Node<T> last;
    private int size=0;

    public MyNodeList() {
        size = 0;
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
    public void remove(int index) {
        int ind = 0;
        Node<T> node = first;
        while (node != last){
            if(ind == index){
                node.next.prev = node.prev;
                node.prev.next = node.next;
                size--;
            }
            ind++;
            node = node.next;
        }
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

    //возвращает первый элемент в очереди (FIFO)
    @Override
    public T peek(){
        return first.elem;
    }

    public Node<T> getFirst() {
        return first;
    }

    public Node<T> getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }

    public void setSize(int size) {
        this.size = size;
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
