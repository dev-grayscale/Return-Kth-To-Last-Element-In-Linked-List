/**
 * For this challenge, we'll assume a simple singly liked list like the following:
 *
 * public class Node {
 *   public Node next;
 *   public int data;
 *
 *   public Node(int data) {
 *     this.data = data;
 *   }
 *
 *   @Override
 *   public String toString() {
 *     StringBuilder sb = new StringBuilder();
 *
 *     Node nextNode = next;
 *
 *     sb.append(data);
 *
 *     while (nextNode != null) {
 *       sb.append("->");
 *
 *       sb.append(nextNode.data);
 *
 *       nextNode = nextNode.next;
 *     }
 *
 *     return sb.toString();
 *   }
 * }
 *
 * Implement an algorithm to find the kth to last element of a singly linked list.
 *
 * <ol>
 *   <li>If k <= 0 -> return null</li>
 *   <li>If k == 1 -> return last node</li>
 *   <li>If k == 2 -> return second to last node</li>
 *   <li>If k > linked list length -> return null</li>
 * </ol>
 */
public class Main {
  /**
   * The first solution gets the total elements (length) by counting them by traversing through the linked list.
   * Then visits each node again and returns the one on position = length - k
   *
   * <b>If k > length -> return null</b>
   *
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static Node returnKthToLastV1(Node n, int k) {
    if (n == null || k <= 0) {
      return null;
    }

    // pointer to the initial state
    Node node = n;
    int length = 0;

    while (n != null) {
      length++;

      n = n.next;
    }

    while (node != null) {
      if (length-- == k) {
        return node;
      }

      node = node.next;
    }

    return null;
  }

  /**
   * The challenge could be solved with the usage of "runner" technique.
   *
   * We initialize 2 pointers: 1 to the 1st node (slow) and 1 with advance of k positions (runner), if k < linked list length.
   * Then we increment the position of the runner and until the end is reached -> also increment the slow pointer.
   * This way we keep the necessary distance (k nodes) and when the end is reached, slow will be k positions from the end.
   *
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static Node returnKthToLastV2(Node n, int k) {
    if (n == null || k <= 0) {
      return null;
    }

    Node slow = n;
    Node runner = n;

    // advance k positions
    while (runner != null && k-- > 1) {
      runner = runner.next;
    }

    // not enough length for k
    if (runner == null) {
      return null;
    }

    while (runner.next != null) {
      slow = slow.next;
      runner = runner.next;
    }

    return slow;
  }
}
