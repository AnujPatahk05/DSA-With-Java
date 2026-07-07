public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int value) {
        this.val = value;
        this.next = null;
    }

    public ListNode(int value, ListNode next) {
        this.val = value;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode node = this;
        StringBuilder sb = new StringBuilder();
        while(node != null) {
            sb.append(node.val);
            sb.append(" -> ");
            node = node.next;
        }
        sb.append(" null");

        return sb.toString();
    }
}
