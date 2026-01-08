package ca.umanitoba.leetcode;

public class PriorityQueue {
    private int[] heap = new int[100];
    private int size;

    public void offer(int value) {
        heap[size] = value;
        siftUp(size);
        size++;
    }

    public int poll() {
        int result = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return result;
    }

    private void siftDown(int i) {
        int j = i, left = i * 2 + 1, right = i * 2 + 2;
        if (left < size && heap[left] < heap[i]) j = left;
        if (right < size && heap[right] < heap[i]) j = right;
        if (i == j) return;
        swap(i, j);
        siftDown(j);
    }

    private void siftUp(int i) {
        if (i == 0) return;
        int j = (i - 1) / 2;
        if (heap[j] > heap[i]) {
            swap(j, i);
            siftUp(j);
        }
    }

    private void swap(int i, int j) {
        int num = heap[i];
        heap[i] = heap[j];
        heap[j] = num;
    }
}
