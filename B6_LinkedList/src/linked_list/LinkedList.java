package linked_list;

import javax.management.RuntimeErrorException;

public class LinkedList<T> {
    private Node<T> head;

    // constructor của class LinkedList không có phần tử
    public LinkedList() {
        this.head = null;
    }

    // Duyệt qua toàn bộ ds và in ra từng phần tử
    public void traverse() {
        Node<T> tmp = head;
        while (tmp != null) {
            // In phần tử ra
            System.out.println(tmp.getData());
            tmp = tmp.getNext();
        }
    }

    // Thêm vào đầu một node
    public void addFirst(T item) {
        // Bước 1: next của newNode chỉ về head
        Node<T> newNode = new Node<>();
        newNode.setData(item);
        newNode.setNext(this.head);

        // Bước 2: head chỉ về ta newNode
        this.head = newNode;
    }

    // Thêm vào cuối một node
    public void addLast(T item) {
        if (head == null) {
            addFirst(item);
        } else {
            // Tạo ra cái node mới
            Node<T> newNode = new Node<>(item, null);
            Node<T> tmp = head;
            // Duyệt từng node một cho đến node cuối cùng
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();    // đang duyệt các node của mảng, đi tới phía trước
            }
            tmp.setNext(newNode);  // gán next của node cuối cùng bằng node mới
        }
    }

    // Thêm vào phía sau một node
    public void insertAfter(T key, T toInsert) {
        // Bước 1: tạo cái node mới
        Node<T> newNode = new Node<>();
        newNode.setData(toInsert); // khởi tạo giá trị của node là toInsert
        // Bước 2: đi tìm vị trí của key
        Node<T> tmp = head; // mục đích tạo ra tmp duyệt từ head trở đi
        while (tmp != null && !tmp.getData().equals(key)) {
            tmp = tmp.getNext(); //// đang duyệt các node của mảng, đi tới phía trước
        }
        // Tìm ra được Node chứa key, hoặc là đi đến cuối cái linkedlist

        // Thêm vào khi tmp != null
        if (tmp != null) {
            // Bước 2: tmp sẽ chỉ đến nút current
            newNode.setNext(tmp.getNext());
            // Bước 3:
            tmp.setNext(newNode);
        }

    }

    // Xóa một cái node
    public void remove(T key) {
        if (head == null) 
            throw new RuntimeException("can not delete");
        // Xóa nếu key nằm ở vị trí đầu tiên
        if (head.getData().equals(key)) {
            this.head = head.getNext();
        
        }
        // Xóa nếu key nằm ở vị trí bất kỳ
        Node<T> prev = null;
        Node<T> cur = head;
        while (cur!= null && !cur.getData().equals(key)) {
            prev = cur;
            cur = cur.getNext();
        }

        if (cur == null) 
            throw new RuntimeException("can not delete");
        
        prev.setNext(cur.getNext());
    }
    // Kiểm tra xem đối tượng có hay không
    public boolean findItem(T item) {
        Node<T> tmp = head;
        while ( tmp!=null) {
            if(tmp.getData().equals(item)){
                return true;
            }
            // Chuyển đến phần tử tiếp theo
            tmp=tmp.getNext();
        }
        return false;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}
