package com.fishdev.datastructure;

public class DataStructures {

    public interface Structures{
        public void insert(String value);
        public void delete(String value);
        public void display();
    }

    public static class Node{
        String value;
        Node next;
        Node prev;

        public Node(String _value){
            value = _value;
            next = null;
            prev = null;
        }
    }

    /* *************************************************
      Array Structure
     ************************************************* */

    public static class Array implements Structures {

        @Override
        public void insert(String value) {
            System.out.println("\t\t\t-Run Insert");
        }

        @Override
        public void delete(String value) {
            System.out.println("\t\t\t-Run Delete");
        }

        @Override
        public void display() {
            System.out.println("\t\t\t-Run Display");
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
            selectedNode.next.prev = selectedNode;      //Add the prev node of the new node

            System.out.println("\t\t\t\t~Complete Insertion");
        }

        @Override
        public void delete(String value) {

            if(head == null){
                System.out.println("\t\t\t\t~No node found in Linked List. Please add node.");
                return;
            }

            Node selectedNode = head;

            //FIRSTLY, CHECK THE HEAD IF MATCHES THE VALUE
            if(head.value.equals(value)){
                head = head.next;                       //MAKE THE NEXT NODE A HEAD
                System.out.println("\t\t\t\t~"+ value + " Successfully Deleted");
                return;
            }

            //SECONDLY, SEARCH FOR THE MATCH VALUE AND STORE THE PREV NODE
            while(!selectedNode.value.equals(value)){
                if(selectedNode.next != null) {
                    selectedNode.next.prev = selectedNode;
                    selectedNode = selectedNode.next;
                    continue;
                }else{
                    System.out.println("\t\t\t\t~No matching value found. Please try again");
                    return;
                }
            }

            //LASTLY, CHANGE THE NEXT ADDRESS OF PREV NODE TO THE NEXT NODE OF SELECTED NODE
            if(selectedNode.next != null){
                selectedNode.prev.next = selectedNode.next;
                System.out.println("\t\t\t\t~"+ value + " Successfully Deleted");
                return;
            }
            selectedNode.prev.next = null;
            System.out.println("\t\t\t\t~"+ value + " Successfully Deleted");
        }

        @Override
        public void display() {
            System.out.println("\t\t\t-Run Display");
            Node selectedNode = head;

            while(selectedNode != null){
                if(selectedNode.next != null){
                    System.out.print(selectedNode.value + "-->");
                    selectedNode = selectedNode.next;
                }else{
                    System.out.print(selectedNode.value);
                    return;
                }
            }

        }

        public void reverse(){

            if (head == null) { // Prevents NullPointerException
                System.out.println("\t\t\t\t~Linked List is empty, cannot reverse.");
                return;
            }
            Node selectedNode = head;
            Node temp = null;

            while(selectedNode != null){
                temp = selectedNode.prev;
                selectedNode.prev = selectedNode.next;
                selectedNode.next = temp;
                selectedNode = selectedNode.prev;
            }

            if(temp != null){
                head = temp.prev;
            }
        }

        public void removeDuplicate() {
            System.out.println("\t\t\t-Run Remove Duplicate");
        }
    }

    /* *************************************************
      Stack Structure
     ************************************************* */

    public static class Stack implements Structures {

        @Override
        public void insert(String value) {
            System.out.println("\t\t\t-Run Insert");

        }

        @Override
        public void delete(String value) {
            System.out.println("\t\t\t-Run Delete");

        }

        @Override
        public void display() {
            System.out.println("\t\t\t-Run Display");

        }
    }

    /* *************************************************
      Queue Structure
     ************************************************* */

    public static class Queue implements Structures {
        @Override
        public void insert(String value) {
            System.out.println("\t\t\t-Run Insert");
        }

        @Override
        public void delete(String value) {
            System.out.println("\t\t\t-Run Delete");
        }

        @Override
        public void display() {
            System.out.println("\t\t\t-Run Display");
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
        public void delete(String value) {
            System.out.println("\t\t\t-Run Delete");
        }

        @Override
        public void display() {
            System.out.println("\t\t\t-Run Display");
        }
    }
}
