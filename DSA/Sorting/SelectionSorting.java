public class SelectionSorting {
    void sort (int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min_index = i;
            for(int j = i+1; j < n; j++) {
                if (arr[j] < arr[min_index]) min_index = j;
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
    }
    void println (int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        SelectionSorting sorting = new SelectionSorting();
        int[] arr = {3,5,1,7,9,10,52,12};
        sorting.sort(arr);
        System.out.println("Sorted Array");
        sorting.println(arr);
    }
}
