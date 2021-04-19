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
            Object[] newArr = new Object [myArrayList.length+DEFAULT_LENGTH];
            System.arraycopy(myArrayList, 0, newArr, 0, myArrayList.length);
            myArrayList = newArr;
        }
        myArrayList[size] = value;
        size++;
    }

    @Override
    public void remove(int index) {
        Object[] newArr = new Object [myArrayList.length];
        System.arraycopy(myArrayList, 0, newArr, 0, index);
        // остальное сдвинуть на 1 влево
        System.arraycopy(myArrayList, index+1, newArr, index, size-index);
        size--;
        myArrayList = newArr;
    }

    @Override
    public void clear() {
        myArrayList = EMPTY_ARRAY;
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
        for(Object element: myArrayList) {
            arr+=" "+element+" ";
        }
        arr+="]";
        return arr;
    }
}
