package Sort;

import java.util.Arrays;

public class HeapSort {
    // 堆排序入口方法
    public static void heapSort(int[] arr) {
        int n = arr.length;
        // 构建大顶堆（从最后一个非叶子节点开始）
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // 依次交换堆顶与末尾元素，并调整堆
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    // 调整堆（递归）
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;    // 当前父节点
        int left = 2 * i + 1;  // 左子节点
        int right = 2 * i + 2; // 右子节点

        // 比较左子节点与父节点
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        // 比较右子节点与父节点
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        // 若最大值不是父节点，交换并递归调整
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    // 交换数组元素
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 测试代码
    public static void main(String[] args) {
        int[] arr = {3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
        // 输出：[0, 1, 2, 3, 3, 4, 5, 5, 6, 6, 8, 8, 9]
    }
}