package myCollections;

import java.sql.Array;
import java.util.Arrays;

public class MyHashMap<K,V> implements IMyMap<K,V>{
    private static NodePair[] table;
    private int size;
    private final int DEFAULT_CAPACITY = 1 << 4;
    private final int MAXIMUM_SIZE_OF_BACKET = 1 << 7;

    public MyHashMap() {
        table = new NodePair[DEFAULT_CAPACITY];
        size = 0;
    }

    //добавляет пару ключ + значение
    @Override
    public void put(K key, V value) {
        int index = calcHash(key, table.length);
        NodePair<K,V> nodePair = table[index];
        if (nodePair == null) {
            table[index] = new NodePair<>(key, value, index, null);
        }
        if (nodePair != null) {
            int sizeBucket = 0;
            while (nodePair.next != null) {
                if (key.equals(nodePair.getKey())) {
                    // reset value
                    nodePair.setValue(value);
                    return;
                }
                nodePair = nodePair.next;
                sizeBucket++;
            }
            if (key.equals(nodePair.getKey())) {
                // reset value
                nodePair.setValue(value);
                return;
            }
            nodePair.next = new NodePair<K, V>(key, value, index, null);
            sizeBucket++;
            if (sizeBucket >= MAXIMUM_SIZE_OF_BACKET) resize();
        }
        size++;
    }

    private void resize() {
        NodePair[] newTable =  new NodePair[table.length * 2];
        for(int i=0; i < table.length; i++) {
            NodePair<K, V> nodePair = table[i];
            if (nodePair != null) {
                addNewNode(nodePair, newTable);
                while (nodePair.next != null) {
                    addNewNode(nodePair.next, newTable);
                    nodePair = nodePair.next;
                }
            }
        }
        table = newTable;
    }

    private void addNewNode(NodePair<K,V> oldNodePair, NodePair[] newTable){
        int index = calcHash(oldNodePair.getKey(), newTable.length);
        NodePair<K,V> newNodePair = newTable[index];
        if(newNodePair==null){
            newTable[index] = new NodePair<>(oldNodePair.getKey(), oldNodePair.getValue(), index, null);
        }
        else if (newNodePair!=null){
            while(newNodePair.next!=null)  newNodePair = newNodePair.next;
            newNodePair.next = new NodePair<>(oldNodePair.getKey(), oldNodePair.getValue(), index, null);
        }
    }

    private int calcHash(K key, int length) {
        if(key==null) return 0;
        return key.hashCode() % length;
    }

    //удаляет пару по ключу
    @Override
    public void remove(Object key) {
        for(int i=0; i < table.length;i++){
            if(table[i] != null){
                NodePair<K,V> nodePair = table[i];
                if(key.equals(nodePair.getKey())) {
                    table[i] = nodePair.next;
                    size--;
                    return;
                }
                while (nodePair.next != null){
                    if (key.equals(nodePair.next.getKey())){
                        NodePair<K,V> oldNodePair = nodePair.next;
                        nodePair.next = nodePair.next.next;
                        size--;
                        return;
                    }
                    nodePair = nodePair.next;
                }
            }
        }
    }

    //очищает коллекцию
    @Override
    public void clear(){
        table = new NodePair[DEFAULT_CAPACITY];
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
        for(int i=0; i < table.length;i++){
            if(table[i] != null){
                NodePair<K,V> nodePair = table[i];
                if(key.equals(nodePair.getKey())) {
                    return nodePair.getValue();
                }
                while (nodePair.next != null){
                    if (key.equals(nodePair.next.getKey())){
                        return nodePair.next.getValue();
                    }
                    nodePair = nodePair.next;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String arr = "[\n";
        for(int i=0; i < table.length;i++) {
            if (table[i] != null) {
                arr += "("+i+")  ";
                NodePair<K, V> nodePair = table[i];
                while (nodePair.next != null) {
                    arr += nodePair.toString();
                    nodePair = nodePair.next;
                }
                arr += nodePair.toString();
            }
        }
        arr+="]";
        return arr;
    }
}
