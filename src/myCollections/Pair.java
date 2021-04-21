package myCollections;

import java.util.Objects;

class Pair<K,V>{
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
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
        Pair<K, V> pair = (Pair<K, V>) o;
        return key.equals(pair.key) && Objects.equals(value, pair.value);
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
        return "NP{" +
                "K=" + key +
                ", V=" + value +
                '}';
    }
}
