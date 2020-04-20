public class OpenHashTable {

  private LinkedList[] buckets = new LinkedList[10];

  protected void addValue(int value) {
    int hashedValue = value % 10;

    if (buckets[hashedValue] == null) {
      buckets[hashedValue] = new LinkedList();
    }

    buckets[hashedValue].add(value);
  }

  protected void removeValue(int value) {
    int hashedValue = value % 10;

    if (buckets[hashedValue] == null) {
      return;
    }

    buckets[hashedValue].remove(value);
  }

  protected void searchTable(int value) {
    int hashedValue = value % 10;

    if (buckets[hashedValue] == null) {
      System.out.println("Item not in table");
      return;
    }

    buckets[hashedValue].searchList(value);
  }

  protected void printHashTable() {
    for (int i = 0; i < buckets.length; i++) {
      if (buckets[i] == null) {
        System.out.printf("%d: \n", i);
      } else {
        System.out.printf("%d: ", i);
        buckets[i].printList();
      }
    }
  }

  public static void main(String[] args) {
    OpenHashTable test = new OpenHashTable();
    test.addValue(15);
    test.addValue(11);
    test.addValue(20);
    test.addValue(35);
    test.addValue(3);
    test.addValue(12);
    test.addValue(32);
    test.addValue(23);
    test.printHashTable();
    System.out.println("-------------------------");
    test.removeValue(35);
    test.printHashTable();
    test.searchTable(23);
    test.searchTable(8);
  }
}
