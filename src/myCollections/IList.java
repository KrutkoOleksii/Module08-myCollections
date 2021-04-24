package myCollections;

public interface IList<T> {
    void add(T value);      //добавляет элемент в конец
    String remove(int index); //удаляет элемент под индексом
    void clear();           //очищает коллекцию
    int size();             //возвращает размер коллекции
    T get(int index);       //возвращает элемент под индексом
}
