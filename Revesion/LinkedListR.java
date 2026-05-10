package Revesion;
class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}


class LinkedList{
    Node head;
    Node tail;
    int size;

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

    public void reverse(){
        if(head == null || head.next == null)
            return;

        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public boolean isPalindrome(){
        // 1. Find Mid Node
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.data);

        Node mid = slow;

        //2 . Reverse Second half

        Node prev = null;
        Node curr = mid;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 3. Compare left and right half

        boolean isPalindrome = true;

        Node left = head;
        Node right = prev;

        while(right != null){
            if(left.data != right.data){
                isPalindrome = false;
                break;
            }

            left = left.next;
            right = right.next;
        }

        // 4. Restore second half

        curr = prev;
        prev = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return isPalindrome;
    }

    public boolean detectCycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
    }

    public boolean removeCycle(){
        Node slow = head;
        Node fast = head;

        boolean isCycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
                break;
            }
        }

        slow = head;
        Node prev = null;

        while(slow != fast){
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        prev.next = null;

        return isCycle;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null) return head;

        //1. Finding Mid Node 
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;

        //2. Dividing into two halves

        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // 3. Merge left and right

        Node temp = new Node(-1);
        Node mergedLLHead = temp;

        while(newLeft != null && newRight != null){
            if(newLeft.data <= newRight.data){
                temp.next = newLeft;
                newLeft = newLeft.next;
            }else{
                temp.next = newRight;
                newRight = newRight.next;
            }
            temp = temp.next;
        }

        if(newLeft != null){
            temp.next = newLeft;
        }

        if(newRight != null){
            temp.next = newRight;
        }

        return mergedLLHead.next;
    }

    public void zigZag(){
        // 1. Find mid
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;

        //2. Reverse second 
        
        Node nextToMid = mid.next;
        mid.next = null;

        Node prev = null;
        Node curr = nextToMid;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 3. Converting To Zig Zag

        Node LH = this.head;
        Node RH = prev;

        Node nextLH;
        Node nextRH;

        while(LH != null && RH != null){
            nextLH = LH.next;
            nextRH = RH.next;

            LH.next = RH;
            RH.next = nextLH;

            LH = nextLH;
            RH = nextRH;
        }

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

public class LinkedListR{
    public static  void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new Node(1);
        ll.head.next = new Node(3);
        ll.head.next.next = new Node(2);
        ll.head.next.next.next = new Node(4);
        ll.head.next.next.next.next = new Node(5);
        ll.head.next.next.next.next.next = new Node(6);
        // ll.head.next.next.next.next.next.next = ll.head.next.next;
        /*
            1 → 2 → 3 → 4
                    ↑   ↓
                    6 ← 5
         */
        
        
    }

}