public class DoublyLinkedList {
  private DoubleListNode root;
  private DoubleListNode tail;

  protected void add(int value) {
    if (root == null) {
      root = new DoubleListNode(value);
      tail = root;
      return;
    }

    DoubleListNode newNode = new DoubleListNode(value);
    newNode.prev = tail;
    tail.next = newNode;
    tail = newNode;
  }

  protected void remove(int value) {
    if (root == null) {
      return;
    }

    if (root.value == value) {
      root = root.next;
      return;
    }

    DoubleListNode currentNode = root;

    while (currentNode.value != value) {
      currentNode = currentNode.next;
    }

    if (currentNode == tail) {
      tail.prev.next = null;
      tail = tail.prev;
      return;
    }

    currentNode.prev.next = currentNode.next;
    currentNode.next.prev = currentNode.prev;
  }

  protected void printList() {
    if (root == null) {
      return;
    }

    System.out.println("Front to back");
    System.out.printf("%d", root.value);
    DoubleListNode currentNode = root.next;

    while (currentNode != null) {
      System.out.printf(", %d", currentNode.value);
      currentNode = currentNode.next;
    }

    System.out.println("\nBack to front");
    System.out.printf("%d", tail.value);
    currentNode = tail.prev;

    while (currentNode != null) {
      System.out.printf(", %d", currentNode.value);
      currentNode = currentNode.prev;
    }

    System.out.println();
  }

  protected void searchList(int value) {
    if (root == null) {
      System.out.println("Item not in list");
      return;
    }

    DoubleListNode currentNode = root;
    int count = 1;

    while (currentNode.value != value) {
      if (currentNode.next == null) {
        System.out.println("Item not in list");
        return;
      }

      count++;
      currentNode = currentNode.next;
    }

    System.out.printf("Item found at position %d in list\n", count);
  }
}
