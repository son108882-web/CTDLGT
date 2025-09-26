public class MyLinkedList {
    
    public static class Node{
        int value;
        Node next;
        Node (int value){
            this.value = value;
        }
    }

    public static void printLinkedList(Node head){
        if (head == null){
            System.out.println("List is empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.value);  // Giá trị của node hiện i
                temp = temp.next;               // Thao tác con trỏ next của node temp trỏ tới phần tử tiếp theo
                if(temp != null){
                    System.out.println("->");
                } else {
                    System.out.println();
                }
            }
        }
    }

    public static Node addToHead(Node headNode, int value){
        Node newNode = new Node(value);
        if(headNode != null){
            newNode.next = headNode;    // trỏ new vào đầu head
        }
        return newNode;
    }

    public static Node addToTail(Node headNode, int value){
        Node newNode = new Node(value);
        if(headNode != null){
            return newNode;

        } else {
            // B1. Đi xác định Last Node ( Last Node là node có lastNode.nẽt = null)
            Node lastNode = headNode;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            // B2. Gán next cho lastNode = new Node
            lastNode.next =newNode; // Lấy trỏ next của lastNode trỏ đến 
        }
        return newNode;
    }

    public static Node addToIndex(Node heaNode, int value, int index){
        if (index == 0){
            return addToHead(heaNode, value);
        } else {
            // B1. Tìm vị trí cần thêm
            Node newNode = new Node(value);
            Node curNode = heaNode;
            int count = 0;
            while (curNode != null) {
                count++;
                if(count == index){
                    // Thực hiện addToHead
                    newNode.next = curNode.next;
                    curNode.next = newNode;
                    break;
                }
            }
        }
        return heaNode;
    }

    public static Node removeAtHead(Node heaNode){
        if(heaNode != null){
            return heaNode.next;
        }
        return heaNode;
    }

    public static Node removeAtTail(Node heaNode){
        if(heaNode == null)
        return null;

        // B1. Xác định Last và Previous
        Node lastNode = heaNode;
        Node preNode = null;
        while (lastNode.next != null) {// Nếu như LastNode là nút cuối cùng thì lastNode.next = null
            preNode = lastNode;
            lastNode = lastNode.next;           
        }
        // B2. Next của preNode trỏ tới null
        if (preNode == null) {
            return null;
        } else {
            preNode.next = lastNode.next;
        }
        return heaNode;
    }

    public static Node removeAtIndex(Node headNode, int index){
    if(headNode == null || index < 0)
        return null;
    if(index == 0)
        return removeAtHead(headNode);

    Node currNode = headNode;
    Node preNode = null;
    int count = 0;
    boolean bIsFound = false;
    while(currNode!= null){
        if (count == index){
            //Remove currNode
            bIsFound = false;
            break;
        }
        preNode = currNode;
        currNode = currNode.next;
        count++;
    }
    // Remove curr
    if(bIsFound){
        if(preNode == null){ //currNode is Last Node
            return null;
        } else {
            if (currNode != null){
                preNode.next = currNode.next;
            }
        }
    }
    return headNode;
}

    public static void main(String[] args){

    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);

    n1.next = n2;
    n2.next = n3;

    printLinkedList(n1);
    // printLinkedList(n2);
    // printLinkedList(n3);

    // n1 = addToHead(n1, 0);
    // printLinkedList(n1);

    // n1 = addToTail(n1, 0);
    // printLinkedList(n1);

    // n1 = addToIndex(n1, 0, 0);
    // printLinkedList(n1);
    n1 = addToIndex(n1, 4, 0);
    printLinkedList(n1);
    n1 = addToIndex(n1, 1, 1);
    printLinkedList(n1);

    // n1 = removeAtHead(n1);
    // printLinkedList(n1);

    n1 = removeAtTail(n1);
    printLinkedList(n1);

    // n1 = removeAtIndex(n1, 0);
    // printLinkedList(n1);
    // n1 = removeAtIndex(n1, 1);
    // printLinkedList(n1);

}


}
