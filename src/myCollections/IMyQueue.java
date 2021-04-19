package myCollections;

public interface IMyQueue<T> {
    void add(T value);      //добавляет элемент в конец
    void remove(int index); //удаляет элемент под индексом
    void clear();           //очищает коллекцию
    int size();             //возвращает размер коллекции
    T peek();               //возвращает первый элемент в очереди (FIFO)
}
