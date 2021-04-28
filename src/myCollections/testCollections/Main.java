package myCollections.testCollections;

import myCollections.*;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        String[] myArr = {"First", "Second", "Third", "Forth", "Fifth", "Sixth", "Seventh", "Eighth", "Ninth", "Tenth",
                "Eleventh", "Twelfth", "Thirteenth", "Fourteenth", "Fifteenth","16","17","18","19","20",
                "21","22","23","24","25","26","27","28","29","30",
                "31","32","33","34","35","36","37","38","39","40","41"};

        System.out.println(" - - - - - - - - - - - ");
        System.out.println(" - - MyArrayList - - ");
        MyArrayList <String> collection = new MyArrayList<>();
        for (int i=0;i<10;i++){
            collection.add(myArr[i]);
        }
        System.out.println(collection);
        System.out.println("   (size = "+collection.size()+")");
        for (int i=10;i<15;i++){
            collection.add(myArr[i]);
        }
        System.out.println(collection);
        System.out.println("   (size after adding= "+collection.size()+")");
        System.out.println("get index 2 - "+collection.get(2));
        collection.remove(14);
        System.out.println(collection);
        System.out.println("   (size after remove "+collection.size()+")");
        collection.clear();
        System.out.println(collection);
        System.out.println("   (size after clean= "+collection.size()+")");

        System.out.println("\n \n  - - - - - - - - - - - ");
        System.out.println(" - - MyLinkedList - - ");
        MyLinkedList <String> myLinkedList = new MyLinkedList<>();
        for (int i=0;i<10;i++){
            myLinkedList.add(myArr[i]);
        }
        System.out.println(myLinkedList);
        System.out.println("   (size = "+myLinkedList.size()+")");
        for (int i=10;i<15;i++){
            myLinkedList.add(myArr[i]);
        }
        System.out.println(myLinkedList);
        System.out.println("   (size after adding= "+myLinkedList.size()+")");
        System.out.println("get index 2 - "+myLinkedList.get(2));
        myLinkedList.remove(2);
        System.out.println(myLinkedList);
        System.out.println("   (size after remove [2] = "+myLinkedList.size()+")");
        myLinkedList.clear();
        System.out.println(myLinkedList);
        System.out.println("   (size after clean= "+myLinkedList.size()+")");

        System.out.println("\n \n  - - - - - - - - - - - ");
        System.out.println(" - - MyQueue - - ");
        MyQueue<String> queue = new MyQueue<>();
        for (int i=0;i<10;i++){
            queue.add(myArr[i]);
        }
        System.out.println(queue);
        System.out.println("   (size = "+queue.size()+")");
        for (int i=10;i<15;i++){
            queue.add(myArr[i]);
        }
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

        System.out.println("\n \n  - - - - - - - - - - - ");
        System.out.println(" - - MyStack - - ");
        MyStack<String> stack = new MyStack<>();
        for (int i=0;i<10;i++){
            stack.push(myArr[i]);
        }
        System.out.println(stack);
        System.out.println("   (size = "+stack.size()+")");
        for (int i=10;i<15;i++){
            stack.push(myArr[i]);
        }
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

        System.out.println("\n \n  - - - - - - - - - - - ");
        System.out.println(" -- MyHashMap -- ");
        MyHashMap<Integer,String> map = new MyHashMap<>();
        for (int i=0;i<10;i++){
            map.put(i, myArr[i]);
        }
        System.out.println(map);
        System.out.println("   (size = "+map.size()+")");
        for (int i=10; i<41; i++){
            map.put(i, myArr[i]);
        }
        System.out.println(map);
        System.out.println("   (size after add= "+map.size()+")");
        map.remove(5);
        System.out.println(map);
        System.out.println("    (size after remove [key 5]= "+map.size()+")");
        System.out.println(" (key 7, value = "+map.get(7)+")");
        System.out.println(" (key 12, value = "+map.get(12)+")");
        System.out.println(" (key 16, value = "+map.get(16)+")");
        map.clear();
        System.out.println(map);
        System.out.println("    (size after clear= "+map.size()+")");

        //HashMap<Object, Object> hashMap = new HashMap<>(1, 2);

    }
}
