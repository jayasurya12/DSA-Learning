class SelectionSorting {
    void sort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;

            // Find the index of the minimum element in the remaining unsorted array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted array
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SelectionSorting sr = new SelectionSorting();
        int[] arr = {64, 76, 34, 12, 8, 4, 2, 1};
        sr.sort(arr);
        System.out.println("Selection sort");
        sr.printArray(arr);
    }
}
