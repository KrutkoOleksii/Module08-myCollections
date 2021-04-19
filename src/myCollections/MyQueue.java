package myCollections;

public class MyQueue<T> extends MyNodeList<T>{

    //возвращает первый элемент в очереди и удаляет его из коллекции
    public T poll(){
        T elem = getFirst().elem;
        setFirst(getFirst().next);
        getFirst().prev = null;
        setSize(getSize()-1);
        return elem;
    }

}
