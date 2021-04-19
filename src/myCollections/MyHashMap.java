package myCollections;

import java.util.Objects;

public class MyHashMap<K,V> implements IMyMap<K,V>{
    private NodePair<K,V> [] table;
    private int size;

    public MyHashMap() {
        table = new NodePair[10];
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
        NodePair<K,V> nodePair = new NodePair<>(key, value);
        table[size++] = nodePair;
    }

    //удаляет пару по ключу
    @Override
    public boolean remove(Object key) {
        int index = -1;
        for(int i=0; i < table.length;i++){
            if(key.equals(table[i].getKey())){
               index = i;
               break;
            }
        }
        if(index >= 0){
            NodePair<K,V> [] newTable = (NodePair<K, V>[]) new NodePair[table.length];
            System.arraycopy(table,0,newTable,0,index);
            if(index<size) {
                System.arraycopy(table,index+1,newTable,index,size-index);
            }
            table = newTable;
            size--;
            return true;
        }
        return false;
    }

    //очищает коллекцию
    @Override
    public void clear(){
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
        int newSize = table.length * 3 / 2;
        NodePair<K,V> [] newTable = (NodePair<K, V>[]) new NodePair[newSize];
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
