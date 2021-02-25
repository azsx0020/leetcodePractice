package com.adohong.leetcode.practice.revesepair;

public class Solution {

    public int countReversPair(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return countReversPairRecursive(arr, 0, arr.length - 1);
    }

    private int countReversPairRecursive(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }
        int result = 0;
        int mid = start + (end - start) / 2;
        result += countReversPairRecursive(arr, start, mid);
        result += countReversPairRecursive(arr, mid + 1, end);
        result += merge(arr, start, end);
        return result;
    }

    private int merge(int[] arr, int start, int end) {

        int mid = start + (end - start) / 2;
        int count = 0;
        int rightStart = mid + 1;
        for (int i = start; i <= mid && rightStart <=end;) {
            if (arr[i] > arr[rightStart]) {
                count += (mid + 1 - i);
                rightStart++;
            } else {
                i++;
            }
        }

        int[] result = new int[end - start + 1];
        int startLeft = start;
        int startRight = mid + 1;
        int index = 0;
        while (startLeft <= mid && startRight <= end) {
            result[index++] = arr[startLeft] < arr[startRight] ? arr[startLeft++] : arr[startRight++];
        }
        while (startRight <= end) {
            result[index++] = arr[startRight++];
        }
        while (startLeft <= mid) {
            result[index++] = arr[startLeft++];
        }
        for (int i = start; i <= end ; i++) {
            arr[i] = result[i - start];
        }
        return count;

    }

    // for test
    public static int comparator(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        Solution solution = new Solution();
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int result = solution.countReversPair(arr1);
            if (result != comparator(arr2)) {
                System.out.println("Oops!");
                printArray(arr1);
                printArray(arr2);
                System.out.println(result);
                System.out.println(comparator(arr2));
                break;
            }
        }
        System.out.println("测试结束");
    }

}
