package com.fishdev.datastructure;

public class DataStructures {

    public interface Structures{
        public void insert(String value);
        public void display();
    }

    public static class Node{
        String value;
        Node next;

        public Node(String _value){
            value = _value;
            next = null;
        }
    }

    /* *************************************************
      Array Structure
     ************************************************* */

    public static class Array implements Structures {
        String[] array;
        int currentSize = 0;

        @Override
        public void insert(String value) {
            System.out.println("\t\t\t-Run Insert("+ value + ")");
            array[currentSize] = value;
            currentSize++;
        }

        public void insert(String value, String index) {
            System.out.println("\t\t\t-Run Insert("+ value + ")");
            array[Integer.parseInt(index)] = value;
            if(Integer.parseInt(index) > currentSize){
                currentSize = Integer.parseInt(index) + 1;
            }
        }

        @Override
        public void display() {
            for(int i = 0; i < currentSize; i++){
                System.out.print(array[i] + " ");
            }
        }

        public void configArray(int size){
            array = new String[size];
        }

        public void delete(String value) {
            for(int i = 0; i < currentSize; i++){

                if(array[i] != null && array[i].equals(value)){
                    array[i] = null;
                    return;
                }
            }
        }

        public void ascendingOrder(){
            for(int i = 1; i < currentSize; i++){
                String key = array[i];
                int j = i - 1;

                while(j >= 0 && Integer.parseInt(array[j]) > Integer.parseInt(key) ){
                    array[j + 1] = array[j];
                    j = j - 1;
                }
                array[j + 1] = key;
            }
        }

        public void descendingOrder(){
            this.ascendingOrder();
            int j = currentSize - 1;
            String temp;
            for(int i = 0; i < j; i++){
                System.out.println(array[j]);
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                j--;
            }

        }

    }

    /* *************************************************
      Linked List Structure
     ************************************************* */

    public static class LinkedList implements Structures {
        private Node head;

        @Override
        public void insert(String value) {
            System.out.println("\t\t\t-Run Insert("+ value + ")");

            Node newNode = new Node(value);

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

        public void delete(String value) {
           if(head == null){
               System.out.println("\t\t\t\t~Linked List is empty, cannot delete.");
               return;
           }

           Node selectedNode = head;
           Node prev = null;

           if(selectedNode.value.equals(value)){        //Matched value at the front of Linked List
               head = head.next;
               System.out.println("\t\t\t\t~"+ value + " Successfully Deleted");
               return;
           }

           while(selectedNode != null && !selectedNode.value.equals(value)){        //Search matched value in Linked List
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
                    if(innerNode.next.value.equals(outerNode.value)){
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
        public void insert(String value) {
            System.out.println("\t\t\t-Run Push("+ value + ")");

            if(currentSize == maxSize){
                System.out.println("\t\t\t\t~Stack Overflow, Cannot push.");
                return;
            }

            Node newNode = new Node(value);
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

        public String pop() {
            if(top == null){
                return "\t\t\t\t~Stack Underflow, Cannot pop.";
            }

            String poppedValue = top.value;
            top = top.next;
            currentSize--;
            System.out.println("\t\t\t\t~"+ poppedValue + ", Popped Complete.");
            return poppedValue;
        }

        public void modify(String value, String newValue) {
            Node selectedNode = top;

            while(selectedNode != null){
                if(selectedNode.value.equals(value)){
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
        public void insert(String value) {
            System.out.println("\t\t\t-Run Enqueue("+ value + ")");

            Node newNode = new Node(value);

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

            String dequeuedValue = front.value;
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
        @Override
        public void insert(String value) {
            System.out.println("\t\t\t-Run Insert");
        }

        @Override
        public void display() {
            System.out.println("\t\t\t-Run Display");
        }
    }
}
