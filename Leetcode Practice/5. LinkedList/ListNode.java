public class ListNode {
    int value;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode node = this;
        StringBuilder sb = new StringBuilder();
        while(node != null) {
            sb.append(node.value);
            sb.append(" -> ");
            node = node.next;
        }
        sb.append(" null");

        return sb.toString();
    }
}
