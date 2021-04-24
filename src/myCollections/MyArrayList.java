package myCollections;

public class MyArrayList<T> implements IList<T>{
    private static final int DEFAULT_LENGTH = 10;
    private static final Object[] EMPTY_ARRAY = {};
    private int size;
    private Object[] myArrayList;

    public MyArrayList() {
        this.size = 0;
        myArrayList = new Object[DEFAULT_LENGTH];
    }
    public MyArrayList(Integer length) {
        this.size = 0;
        if (length == 0) {
            myArrayList = EMPTY_ARRAY;
        }
        if (length > 0) {
            myArrayList = new Object[length];
        }
    }

    @Override
    public void add(T value) {
        if(size == myArrayList.length) {
            Object[] newArr = new Object [myArrayList.length * 3 / 2 + 1];
            System.arraycopy(myArrayList, 0, newArr, 0, myArrayList.length);
            myArrayList = newArr;
        }
        myArrayList[size] = value;
        size++;
    }

    @Override
    public String remove(int index) {
        if (index >= size){
            return "index (for removing) "+index+" out of bounds for object array["+size+"]";
        }
        Object[] newArr = new Object [myArrayList.length];
        System.arraycopy(myArrayList, 0, newArr, 0, index);
        // остальное сдвинуть на 1 влево
        System.arraycopy(myArrayList, index+1, newArr, index, size-index-1);
        size--;
        myArrayList = newArr;
        return "remove index "+index;
    }

    @Override
    public void clear() {
        myArrayList = new Object[DEFAULT_LENGTH];;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if(index >= size) {
            return null;
        }
        return (T) myArrayList[index];
    }

    @Override
    public String toString() {
        String arr = "[";
        for(int i = 0; i < size; i++) {
            if(!arr.equals("[")) { arr+=", ";}
            arr += myArrayList[i];
        }
        arr+="]";
        return arr;
    }
}
