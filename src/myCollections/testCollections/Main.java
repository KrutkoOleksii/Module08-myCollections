package myCollections.testCollections;

import myCollections.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(" -- MyArrayList -- ");
        MyArrayList <String> collection = new MyArrayList<>();
        collection.add("First");
        collection.add("Second");
        collection.add("Third");
        collection.add("Forth");
        collection.add("Fifth");
        collection.add("6");
        collection.add("7");
        collection.add("8");
        collection.add("9");
        collection.add("10");
        System.out.println(collection);
        System.out.println("   (size = "+collection.size()+")");
        collection.add("11");
        collection.add("12");
        System.out.println(collection);
        System.out.println("   (size after adding= "+collection.size()+")");
        System.out.println("get index 1 - "+collection.get(1));
        collection.clear();
        System.out.println(collection);
        System.out.println("   (size after clean= "+collection.size()+")");


        System.out.println("");
        System.out.println(" -- MyLinkedList -- ");
        MyLinkedList <String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("First");
        myLinkedList.add("Second");
        myLinkedList.add("Third");
        myLinkedList.add("Forth");
        myLinkedList.add("Fifth");
        myLinkedList.add("6");
        myLinkedList.add("7");
        myLinkedList.add("8");
        myLinkedList.add("9");
        myLinkedList.add("10");
        System.out.println(myLinkedList);
        System.out.println("   (size = "+myLinkedList.size()+")");
        myLinkedList.add("11");
        myLinkedList.add("12");
        System.out.println(myLinkedList);
        System.out.println("   (size after adding= "+myLinkedList.size()+")");
        System.out.println("get index 1 - "+myLinkedList.get(1));
        myLinkedList.clear();
        System.out.println(myLinkedList);
        System.out.println("   (size after clean= "+myLinkedList.size()+")");


        System.out.println("");
        System.out.println(" -- MyQueue -- ");
        MyQueue<String> queue = new MyQueue<>();
        queue.add("First");
        queue.add("Second");
        queue.add("Third");
        queue.add("Forth");
        queue.add("Fifth");
        queue.add("6");
        queue.add("7");
        queue.add("8");
        queue.add("9");
        queue.add("10");
        System.out.println(queue);
        System.out.println("   (size = "+queue.size()+")");
        queue.add("11");
        queue.add("12");
        System.out.println(queue);
        System.out.println("   (size after add = "+queue.size()+")");
        queue.remove(2);
        System.out.println(queue);
        System.out.println("   (size after remove [2] = "+queue.size()+")");
        System.out.println("get first element (peek) - "+queue.peek());
        System.out.println("   (size = "+queue.size()+")");
        System.out.println("remove first element (pool) - "+queue.poll()); // for MyQueue
        System.out.println(queue);
        System.out.println("   (size after poll = "+queue.size()+")");
        queue.clear();
        System.out.println(queue);
        System.out.println("   (size after clean= "+queue.size()+")");


        System.out.println("");
        System.out.println(" -- MyStack -- ");
        MyStack<String> stack = new MyStack<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        stack.push("Forth");
        stack.push("Fifth");
        stack.push("6");
        stack.push("7");
        stack.push("8");
        stack.push("9");
        stack.push("10");
        System.out.println(collection);
        System.out.println("   (size = "+stack.size()+")");
        stack.push("11");
        stack.push("12");
        System.out.println(stack);
        System.out.println("   (size after add = "+stack.size()+")");
        stack.remove(2);
        System.out.println(stack);
        System.out.println("   (size after remove [2] = "+stack.size()+")");
        System.out.println("first element (peek)- "+stack.peek());
        System.out.println("   (size = "+stack.size()+")");
        System.out.println("remove last element (pop)- "+stack.pop()); // for MyStack
        System.out.println(stack);
        System.out.println("   (size after pop = "+stack.size()+")");
        stack.clear();
        System.out.println(stack);
        System.out.println("   (size after clean= "+stack.size()+")");

        System.out.println("");
        System.out.println(" -- MyHashMap -- ");
        MyHashMap  map;
        map = new MyHashMap<Integer,String>();
        map.put(11,"First");
        map.put(22,"Second");
        map.put(33,"Third");
        map.put(44,"Forth");
        map.put(55,"Fifth");
        map.put(66,"6");
        map.put(77,"7");
        map.put(88,"8");
        map.put(99,"9");
        map.put(110,"10");
        System.out.println(map);
        System.out.println("   (size = "+map.size()+")");
        map.put(111,"11");
        map.put(222,"12");
        System.out.println(map);
        System.out.println("   (size after add= "+map.size()+")");
        map.remove(66);
        System.out.println(map);
        System.out.println("    (size after remove [key 66]= "+map.size()+")");
        System.out.println(" (key 88, value = "+map.get(88)+")");
        System.out.println(" (key 222, value = "+map.get(222)+")");
        System.out.println(" (key 333, value = "+map.get(333)+")");
        map.clear();
        System.out.println("    (size after clear= "+map.size()+")");
    }
}
