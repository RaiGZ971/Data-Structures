package com.fishdev.datastructure;

public class DataStructures {

    public interface Structures{
        public void insert(int value);
        public void display();
    }

    public static class Node{
        int value;
        Node next, left, right;

        public Node(int _value, String structure){
            switch(structure){
                case "ONE_NODE_PATH":
                    value = _value;
                    next = null;
                    break;
                case "TWO_NODE_PATH":
                    value = _value;
                    left = null;
                    right = null;
                    break;
                default:
                    System.out.println("[NO NUMBER OF NODE PATH AVAILABLE]");
                    break;
            }

        }
    }

    /* *************************************************
      Array Structure
     ************************************************* */

    public static class Array implements Structures {
        int[] array;
        int currentSize = 0;

        @Override
        public void insert(int value) {
            System.out.println("\t\t\t-Run Insert("+ value + ")");
            if(currentSize < array.length){
                array[currentSize] = value;
                currentSize++;
                return;
            }
            System.out.println("\t\t\t\t~Array is full. Please remove item)");

        }

        public void insert(int value, int index) {
            System.out.println("\t\t\t-Run Insert("+ value + ")");
            array[index] = value;
            if(index > currentSize){
                currentSize = index + 1;
                return;
            }
            System.out.println("\t\t\t\t~Index not found. Please try again)");
        }

        @Override
        public void display() {
            for(int i = 0; i < currentSize; i++){
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }

        public void configArray(int size){
            array = new int[size];
        }

        public void delete(int value) {
            for(int i = 0; i < currentSize; i++){

                if(array[i] != 0 && array[i] == value){
                    array[i] = 0;
                    return;
                }
            }
        }

        public void ascendingOrder(){
            for(int i = 1; i < currentSize; i++){
                int key = array[i];
                int j = i - 1;

                while(j >= 0 && array[j] > key){
                    array[j + 1] = array[j];
                    j = j - 1;
                }
                array[j + 1] = key;
            }
        }

        public void descendingOrder(){
            this.ascendingOrder();
            int j = currentSize - 1;
            int temp;
            for(int i = 0; i < j; i++, j--){
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }

    }

    /* *************************************************
      Linked List Structure
     ************************************************* */

    public static class LinkedList implements Structures {
        private Node head;

        @Override
        public void insert(int value) {
            System.out.println("\t\t\t-Run Insert("+ value + ")");

            Node newNode = new Node(value, "ONE_NODE_PATH");

            //CREATE THE FIRST NODE
            if(head == null){
                head = newNode;
                System.out.println("\t\t\t\t~Complete Insertion");
                return;
            }

            //INPUT VALUE TO THE END OF LINKED LIST
            Node selectedNode = head;

            while(selectedNode.next != null){           //Search for the last node(empty next)
                selectedNode = selectedNode.next;
            }

            selectedNode.next = newNode;                //Add the new node

            System.out.println("\t\t\t\t~Complete Insertion");
        }

        @Override
        public void display() {
            Node selectedNode = head;

            while(selectedNode != null){
                System.out.print(selectedNode.value);
                selectedNode = selectedNode.next;

                if (selectedNode != null) {
                    System.out.print("-->");
                }

            }

        }

        public void delete(int value) {
           if(head == null){
               System.out.println("\t\t\t\t~Linked List is empty, cannot delete.");
               return;
           }

           Node selectedNode = head;
           Node prev = null;

           if(selectedNode.value == value){        //Matched value at the front of Linked List
               head = head.next;
               System.out.println("\t\t\t\t~"+ value + " Successfully Deleted");
               return;
           }

           while(selectedNode != null && selectedNode.value != value){        //Search matched value in Linked List
               prev = selectedNode;
               selectedNode = selectedNode.next;
           }

           if(selectedNode == null){                                                //No Result Found
               System.out.println("\t\t\t\t~No Match Found");
               return;
           }

           prev.next = selectedNode.next;                                           //Delete Matched Value in Linked List
           selectedNode = null;

           System.out.println("\t\t\t\t~"+ value + " Successfully Deleted");
        }

        public void reverse() {
            if (head == null) {
                System.out.println("\t\t\t\t~Linked List is empty, cannot reverse.");
                return;
            }

            Node selectedNode = head;
            Node prev = null;
            Node next = null;

            while (selectedNode != null) {
                next = selectedNode.next;                       //Prepare the next node
                selectedNode.next = prev;                       //Set the next value to prev
                prev = selectedNode;                            //Prepare the next Previous(current)
                selectedNode = next;                            //Set current to next node
            }

            head = prev;
        }

        public void removeDuplicate() {
            Node outerNode = head;

            while(outerNode != null){
                Node innerNode = outerNode;

                while(innerNode.next != null){
                    if(innerNode.next.value == outerNode.value){
                        innerNode.next = innerNode.next.next;
                    }else{
                        innerNode = innerNode.next;
                    }
                }
                outerNode = outerNode.next;
            }
        }
    }

    /* *************************************************
      Stack Structure
     ************************************************* */

    public static class Stack implements Structures {
        private Node top = null;
        private int maxSize = 10;
        private int currentSize = 0;

        @Override
        public void insert(int value) {
            System.out.println("\t\t\t-Run Push("+ value + ")");

            if(currentSize == maxSize){
                System.out.println("\t\t\t\t~Stack Overflow, Cannot push.");
                return;
            }

            Node newNode = new Node(value, "ONE_NODE_PATH");
            newNode.next = top;
            top = newNode;
            currentSize++;

            System.out.println("\t\t\t\t~Complete Push");
        }

        @Override
        public void display() {
            Node selectedNode = top;
            String output = "";

            while(selectedNode != null){
                output += "\t" + selectedNode.value + "\n";
                selectedNode = selectedNode.next;

                if(selectedNode != null){
                    output += "\t|\n\t|\n\tV\n";
                }
            }

            System.out.println(output);
        }

        public void pop() {
            if(top == null){
                System.out.println("\t\t\t\t~Stack Underflow, Cannot pop.");
                return;
            }

            int poppedValue = top.value;
            top = top.next;
            currentSize--;
            System.out.println("\t\t\t\t~"+ poppedValue + ", Popped Complete.");
        }

        public void modify(int value, int newValue) {
            Node selectedNode = top;

            while(selectedNode != null){
                if(selectedNode.value == value){
                    selectedNode.value = newValue;
                    System.out.println("\t\t\t\t~"+ value + " Successfully Modified");
                    return;
                }
                selectedNode = selectedNode.next;
            }
        }
    }

    /* *************************************************
      Queue Structure
     ************************************************* */

    public static class Queue implements Structures {
        private Node front;
        private Node rear;

        @Override
        public void insert(int value) {
            System.out.println("\t\t\t-Run Enqueue("+ value + ")");

            Node newNode = new Node(value, "ONE_NODE_PATH");

            //CREATE THE FIRST NODE
            if(front == null){
                front = newNode;
                rear = front;
                System.out.println("\t\t\t\t~Complete Enqueue");
                return;
            }

            //INPUT VALUE TO THE END OF QUEUE and set it to rear
            rear.next = newNode;
            rear = newNode;

            System.out.println("\t\t\t\t~Complete Enqueue");
        }

        @Override
        public void display() {
            Node selectedNode = front;

            while(selectedNode != null){
                System.out.print(selectedNode.value);
                selectedNode = selectedNode.next;

                if(selectedNode != null){
                    System.out.print("<--");
                }
            }
        }

        public void dequeue() {
            if(front == null){
                System.out.println("\t\t\t\t~Queue is empty, cannot dequeue.");
                return;
            }

            int dequeuedValue = front.value;
            front = front.next;
            System.out.println("\t\t\t\t~"+ dequeuedValue + ", Dequeued Complete.");
        }

        public void highlightFront(){

        }

        public void highlightRear(){

        }

    }

    /* *************************************************
      Binary Tree Structure
     ************************************************* */

    public static class BinaryTree implements Structures{
        Node root;

        @Override
        public void insert(int value) {
            System.out.println("\t\t\t-Run Insert");
            
        }

        @Override
        public void display() {
            System.out.println("\t\t\t-Run Display");
        }
    }
}
