package edu.itmo.hyperb0rean.algo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


import static org.junit.jupiter.api.Assertions.*;

public class FibonacciHeapTest {
    private FibonacciHeap heap;

    @BeforeEach
    public void setUp() {
        heap = new FibonacciHeap();
    }

    @Test
    @DisplayName("InsertAndFindMin")
    public void testInsertAndFindMin() {
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);

        // The minimum should be 5 after inserting 10, 5, and 20
        assertEquals(5, heap.findMin().key);
    }

    @Test
    @DisplayName("ExtractMin")
    public void testExtractMin() {
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);

        // Extract the minimum
        FibonacciHeapNode minNode = heap.extractMin();
        assertEquals(5, minNode.key);

        // After extracting min, the new min should be 10
        assertEquals(10, heap.findMin().key);
    }

    @Test
    @DisplayName("ExtractMinFromSingleElement")
    public void testExtractMinFromSingleElement() {
        heap.insert(42);

        // Extract the only element
        FibonacciHeapNode minNode = heap.extractMin();
        assertEquals(42, minNode.key);

        // The heap should now be empty
        assertNull(heap.findMin());
    }

    @Test
    @DisplayName("MultipleExtractions")
    public void testMultipleExtractions() {
        heap.insert(15);
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);

        // Extracting minimums in order
        assertEquals(5, heap.extractMin().key);
        assertEquals(10, heap.extractMin().key);
        assertEquals(15, heap.extractMin().key);
        assertEquals(20, heap.extractMin().key);

        // The heap should now be empty
        assertNull(heap.findMin());
    }

    @Test
    @DisplayName("ConsolidationAfterMultipleInsertions")
    public void testConsolidationAfterMultipleInsertions() {
        heap.insert(30);
        heap.insert(20);
        heap.insert(10);
        heap.insert(40);

        // Extract min should return 10
        assertEquals(10, heap.extractMin().key);

        // The new min should be 20
        assertEquals(20, heap.findMin().key);

        // Extract min should return 20
        assertEquals(20, heap.extractMin().key);

        // The new min should be 30
        assertEquals(30, heap.findMin().key);
    }
}