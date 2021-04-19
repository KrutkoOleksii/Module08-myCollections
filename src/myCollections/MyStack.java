package myCollections;

public class MyStack<T> extends MyNodeList<T>{

    //добавляет элемент в конец
    public void push(T value){
        add(value);
    }

    //возвращает последний элемент в стеке и удаляет его из коллекции
    public T pop() {
        T elem = getLast().elem;
        setLast(getLast().prev);;
        getLast().next = null;
        setSize(getSize()-1);
        return elem;
    }
}
