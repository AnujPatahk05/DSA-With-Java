
class LinkedList{
    private class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private  Node head;
    private Node tail;
    private int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;

        if(tail == null){
            head = tail = newNode;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void add(int data,int index){
        if(index > size){
            System.out.println("Index out of bound");
            return;
        }

        if(index == 0){
            addFirst(data);
            return;
        }else if(index == size){
            addLast(data);
            return;
        }

        Node prev = head;

        for(int i = 0;i < index-1;i++){
            prev = prev.next;
        }

        Node newNode = new Node(data);

        newNode.next = prev.next;
        prev.next = newNode;

        size++;
    }

    public void printList(){
        Node node = head;
        while(node != null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }

    public int size(){
        return size;
    }
}

public class Revesion{
    public static  void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        ll.printList();

        ll.add(22, 6);

        ll.printList();
        // System.out.println(ll.size());
    }
}