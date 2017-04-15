package linkedlists;

import datastructures.ListNode;
import org.junit.jupiter.api.Test;

import static linkedlists.FindOverlappingWithCycles.testOverlappingWithCycles;
import static linkedlists.LinkedListUtil.createLinkedList;
import static org.junit.jupiter.api.Assertions.*;

class FindOverlappingWithCyclesTest {

    private ListNode<Integer> overlap;
    private ListNode<Integer> list1;
    private ListNode<Integer> list2;

    @Test
    void testOverlappingWithCycles1() {
        list1 = createLinkedList(1, 2, 3);
        list2 = createLinkedList(4, 5, 6);
        overlap = null;

        test(overlap, list1, list2);
    }

    @Test
    void testOverlappingWithCycles2() {
        list1 = createLinkedList(1, 2);
        list2 = createLinkedList(1, 2, 3, 4, 5);
        list1.get(2).next = list2.get(3);
        overlap = createLinkedList(2, 3);


        test(overlap, list1, list2);
    }

    @Test
    void testOverlappingWithCycles3() {
        list1 = createLinkedList(1, 2);
        list2 = createLinkedList(2, 3, 4, 5);
        overlap = list1.get(2).next = list2.get(2);


        test(overlap, list1, list2);
    }

    @Test
    void testOverlappingWithCycles4() {
        list1 = createLinkedList(2);
        list2 = createLinkedList(1, 2, 3, 4, 5);
        list1.get(1).next = list2.get(3);
        list2.get(5).next = list2.get(1);
        overlap = createLinkedList(2, 3);


        test(overlap, list1, list2);
    }

    private void test(ListNode<Integer> overlap, ListNode<Integer> list1, ListNode<Integer> list2) {
        ListNode<Integer> result = testOverlappingWithCycles(list1, list2);
        assertEquals(overlap.data, result.data);
        if (overlap.next != null)
            assertEquals(overlap.next.data, result.next.data);
    }

}