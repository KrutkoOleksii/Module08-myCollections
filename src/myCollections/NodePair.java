package myCollections;

import java.util.Objects;

class NodePair<K,V>{
    private K key;
    private V value;
    private int hash;
    NodePair<K,V> next;

    public NodePair(K key, V value, int hash, NodePair<K,V> next) {
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodePair<K, V> nodePair = (NodePair<K, V>) o;
        return key.equals(nodePair.key) && Objects.equals(value, nodePair.value);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37*hash + key.hashCode();
        hash = 37*hash + value.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        String k = (next == null) ? "" : ">>";
        return "{" +
                "K=" + key +
                ", V=" + value +
                "}"+k;
    }
}
