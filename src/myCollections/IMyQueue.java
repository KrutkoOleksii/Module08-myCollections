package myCollections;

public interface IMyQueue<T> {
    void add(T value); //добавляет элемент в конец
    boolean remove(int index); //удаляет элемент под индексом
    void clear(); //очищает коллекцию
    int size(); //возвращает размер коллекции
    T peek(); //возвращает первый элемент в очереди (FIFO)
    T poll(); //возвращает первый элемент в очереди и удаляет его из коллекции
}
