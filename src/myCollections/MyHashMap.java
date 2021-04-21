package myCollections;

public class MyHashMap<K,V> implements IMyMap<K,V>{
    private Pair<K,V>[] table;
    private int size;

    public MyHashMap() {
        table = new Pair[10];
        size = 0;
    }

    //добавляет пару ключ + значение
    @Override
    public void put(K key, V value) {

        for(int i=0; i<size;i++){

            if(key.equals(table[i].getKey())){
               table[i].setValue(value);
               return;
            }
        }
        if(table.length==size){
            resize();
        }
        Pair<K,V> pair = new Pair<>(key, value);
        table[size++] = pair;
    }

    //удаляет пару по ключу
    @Override
    public void remove(Object key) {
        int index = -1;
        for(int i=0; i < table.length;i++){
            if(key.equals(table[i].getKey())){
               index = i;
               break;
            }
        }
        if(index >= 0){
            Pair<K,V>[] newTable = (Pair<K, V>[]) new Pair[table.length];
            System.arraycopy(table,0,newTable,0,index);
            if(index<size) {
                System.arraycopy(table,index+1,newTable,index,size-index-1);
            }
            table = newTable;
            size--;
        }
    }

    //очищает коллекцию
    @Override
    public void clear(){
        table = new Pair[10];
        size = 0;
    }

    //возвращает размер коллекции
    @Override
    public int size() {
        return size;
    }

    //возвращает значение(Object value) по ключу
    @Override
    public V get(K key) {
        for(int i=0; i < size;i++){
            if(key.equals(table[i].getKey())){
                return table[i].getValue();
            }
        }
        return null;
    }

    public void resize() {
        int newSize = table.length * 3 / 2 + 1;
        Pair<K,V>[] newTable = (Pair<K, V>[]) new Pair[newSize];
        System.arraycopy(table,0,newTable,0,table.length);
        table = newTable;
    }

    @Override
    public String toString() {
        String arr = "[";
        for(Object element: table) {
            arr+=" "+element+" ";
        }
        arr+="]";
        return arr;
    }
}
