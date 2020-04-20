public class LinkedList {

  private ListNode root;

  protected void add(int value) {
    if (root == null) {
      root = new ListNode(value);
      return;
    }

    ListNode currentItem = root;

    while (currentItem.next != null) {
      currentItem = currentItem.next;
    }

    currentItem.next = new ListNode(value);
  }

  protected void remove(int value) {
    if (root == null) {
      return;
    }

    if (root.value == value) {
      root = root.next;
      return;
    }

    ListNode currentItem = root;

    while (currentItem.value != value) {
      if (currentItem.next == null) {
        return;
      }

      if (currentItem.next.value == value) {
        break;
      }

      currentItem = currentItem.next;
    }

    currentItem.next = currentItem.next.next;
  }

  protected void printList() {
    if (root == null) {
      return;
    }

    System.out.print(root.value);
    ListNode currentItem = root.next;

    while (currentItem != null) {
      System.out.printf(", %d", currentItem.value);
      currentItem = currentItem.next;
    }

    System.out.println();
  }

  protected void searchList(int value) {
    if (root == null) {
      System.out.println("Item not in list");
      return;
    }

    ListNode currentItem = root;
    int count = 1;

    while (currentItem.value != value) {
      if (currentItem.next == null) {
        System.out.println("Item not in list");
        return;
      }

      count++;
      currentItem = currentItem.next;
    }

    System.out.printf("Item found at position %d in list\n", count);
  }
}
