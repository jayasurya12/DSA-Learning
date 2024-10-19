public class BubbleSort  {
    static void bubbleSort(int[] arr, int n) {
        int i, j, temp;
        boolean swapped;
        for(i = 0; i < n; i++) {
            swapped = false;
            for(j = 0; j < n-i-1; j++) {
                if (arr[j] < arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
    static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
    }
    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        bs.bubbleSort(arr, arr.length);
        System.out.print("Sorted Array: ");
        bs.printArray(arr, arr.length);
    }
}


