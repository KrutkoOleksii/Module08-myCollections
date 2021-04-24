package myCollections;

public class MyHashMap<K,V> implements IMyMap<K,V>{
    private static NodePair[] table;
    private int size;
    private final int DEFAULT_CAPACITY = 16;

    public MyHashMap() {
        table = new NodePair[DEFAULT_CAPACITY];
        size = 0;
    }

    //добавляет пару ключ + значение
    @Override
    public void put(K key, V value) {
        int index = calcHash(key);
        NodePair<K,V> nodePair = table[index];
        if (nodePair == null) {
            table[index] = new NodePair<>(key, value, index, null);
        }
        if (nodePair != null) {
            while (nodePair.next != null) {
                if (key.equals(nodePair.getKey())) {
                    // reset value
                    nodePair.setValue(value);
                    return;
                }
                nodePair = nodePair.next;
            }
            if (key.equals(nodePair.getKey())) {
                // reset value
                nodePair.setValue(value);
                return;
            }
            nodePair.next = new NodePair<K, V>(key, value, index, null);
        }
        size++;
    }

    private int calcHash(K key) {
        if(key==null) return 0;
        return key.hashCode() & DEFAULT_CAPACITY-1;
    }

    //удаляет пару по ключу
    @Override
    public NodePair<K,V> remove(Object key) {
        for(int i=0; i < table.length;i++){
            if(table[i] != null){
                NodePair<K,V> nodePair = table[i];
                if(key.equals(nodePair.getKey())) {
                    table[i] = nodePair.next;
                    size--;
                    return nodePair;
                }
                while (nodePair.next != null){
                    if (key.equals(nodePair.next.getKey())){
                        NodePair<K,V> oldNodePair = nodePair.next;
                        nodePair.next = nodePair.next.next;
                        size--;
                        return oldNodePair;
                    }
                    nodePair = nodePair.next;
                }
            }
        }
        return null;
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
        String arr = "[";
        for(int i=0; i < table.length;i++) {
            if (table[i] != null) {
                if (!arr.equals("[")) {
                    arr += ", ";
                }
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
