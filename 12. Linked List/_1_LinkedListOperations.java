import Revesion.Node;

class LinkedListIndexOutOfBoundException extends Exception{
    @Override
    public String toString(){
        return "LinkedListIndexOutOfBoundException !";
    }
}

class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
}

class Linkedlist{
    public Node head;
    public Node tail;
    public int size = 0;

    

    public void addFirst(int data){
        //1. Creating new Node
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            size++;
            return;
        }

        //2. newNode's next <- head
        newNode.next = head;

        //3.head <- newNode
        head = newNode;

        size++;
        

    }

    public void addLast(int data){
        //1. Creating new node
        Node newNode = new Node(data);
        if(tail == null){
            head = tail = newNode;
            size++;
            return;
        }

        //2. 
        tail.next = newNode;

        //3.
        tail = newNode;
        size++;
    }

    public void add(int data,int index){
        if(index == 0){
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);

        int idx = 0;
        Node node = head;

        while(idx != index-1){
            if(node == null){
                return;
            }
            node = node.next;
            idx++;
        }

        
        newNode.next = node.next;
        node.next = newNode;
        size++;
         
    }

    public void printElements(){
        if(head == null){
            System.out.println("LinkedList is empty.");
            return;
        }

        Node node = head;

        while(node != null){
            System.out.print(node.data+"->");
            node = node.next;
        }

        System.out.print("null\n");
    }

    public int ValueAtIdx(int idx) {
        if(idx == 0){
            return head.data;
        }

        Node node = head;
        for(int i = 0;i < idx;i++){
            node = node.next;
            if(node == null)return -1;
            
        }

        return node.data;
    }

    public void removeFirst(){
        if(head == null){
            System.out.println("List is already empty");
            return;
        }

        head = head.next;
        size--;

        if(head == null){
            tail = null;
        }
    }

    public void removeLast(){
        if(size == 0){
            System.out.println("List is already empty!");
            return;
        }else if(size == 1){
            head = tail = null;
            return;
        } 
        Node prev = head;
        for(int i = 0;i < size-2;i++){
            prev = prev.next;
        }

        prev.next = null;
        tail = prev;
        
    }

    public void removeAtIndex(int idx){
        if(idx >= size){
            System.out.println("Index out of bound");
            return;
        }else if(idx == size-1){
            removeLast();
            return;
        }else if(idx == 0){
            removeFirst();
            return;
        }

        Node prev = head; 

        for(int i = 0;i < idx-1;i++){
            prev = prev.next;
        }

        prev.next = prev.next.next;
        size--;
    }

    public int iterativeSearch(int element){
        Node node = head;
        int i = 0;
        while(node != null){
            if(node.data == element){
                return i;
            }
            node = node.next;
            i++;
        }
        return -1;
    }

    public int recursiveSearch(int element,int i,Node node){
        if(node == null){
            return -1;
        }
        if(node.data == element){
            return i;
        }
        return recursiveSearch(element, i+1, node.next);
    }
}

    

public class _1_LinkedListOperations {

    public static void main(String[] args) {
        Linkedlist l1 = new Linkedlist();
        l1.addFirst(10);
        l1.addLast(20);
        l1.addFirst(30);
        l1.addFirst(40);
        l1.addLast(50);
        l1.addLast(100);

        l1.printElements();//40 30 10 20 50 100

        System.out.println(l1.recursiveSearch(30,0,l1.head));
        System.out.println(l1.recursiveSearch(123,0,l1.head));

      
        

        

        

    }
}




