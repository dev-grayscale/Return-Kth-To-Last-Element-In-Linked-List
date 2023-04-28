import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void returnKthToLastV1() {
    Assertions.assertNull(Main.returnKthToLastV1(null, 1));
    Assertions.assertNull(Main.returnKthToLastV1(build(1,2), -2));
    Assertions.assertNull(Main.returnKthToLastV1(build(1,2), 0));
    Assertions.assertNull(Main.returnKthToLastV1(build(1,2), 3));

    Assertions.assertEquals(2, Main.returnKthToLastV1(build(1,2), 1).data);
    Assertions.assertEquals(1, Main.returnKthToLastV1(build(1,2), 2).data);
    Assertions.assertEquals(5, Main.returnKthToLastV1(build(1,2,3,4,5,6), 2).data);
    Assertions.assertEquals(4, Main.returnKthToLastV1(build(1,2,3,4,5,6), 3).data);
    Assertions.assertEquals(3, Main.returnKthToLastV1(build(1,2,3,4,5,6), 4).data);
    Assertions.assertEquals(2, Main.returnKthToLastV1(build(1,2,3,4,5,6), 5).data);
    Assertions.assertEquals(1, Main.returnKthToLastV1(build(1,2,3,4,5,6), 6).data);
  }

  @Test
  void returnKthToLastV2() {
    Assertions.assertNull(Main.returnKthToLastV2(null, 1));
    Assertions.assertNull(Main.returnKthToLastV2(build(1,2), -2));
    Assertions.assertNull(Main.returnKthToLastV2(build(1,2), 0));
    Assertions.assertNull(Main.returnKthToLastV2(build(1,2), 3));

    Assertions.assertEquals(2, Main.returnKthToLastV2(build(1,2), 1).data);
    Assertions.assertEquals(1, Main.returnKthToLastV2(build(1,2), 2).data);
    Assertions.assertEquals(5, Main.returnKthToLastV2(build(1,2,3,4,5,6), 2).data);
    Assertions.assertEquals(4, Main.returnKthToLastV2(build(1,2,3,4,5,6), 3).data);
    Assertions.assertEquals(3, Main.returnKthToLastV2(build(1,2,3,4,5,6), 4).data);
    Assertions.assertEquals(2, Main.returnKthToLastV2(build(1,2,3,4,5,6), 5).data);
    Assertions.assertEquals(1, Main.returnKthToLastV2(build(1,2,3,4,5,6), 6).data);
  }

  private static Node build(Integer... values) {
    Node prev = null;
    Node head = null;

    for (Integer value : values) {
      Node n = new Node(value);

      if (prev == null) {
        head = n;
      } else {
        prev.next = n;
      }

      prev = n;
    }

    return head;
  }
}
