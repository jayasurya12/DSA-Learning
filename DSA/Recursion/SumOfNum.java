class SumOfNum {
    static void sum(int num, int sum) {
        if (num < 1) {
            System.out.println(sum);
            return;
        }
        sum(num - 1, sum + num);  // Add num to sum in the recursive call
    }

    static int sum(int num){
        if (num == 0) return 0;
        return num + sum(num-1);
    }

    static int fact(int num) {
        if (num == 1) return 1;
        return num * fact(num - 1);
        //TC O(N) and SC O(N);
    }

    static void reverse(int l, int[] arr, int r) {
        if (l >= r) return;
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        reverse(l + 1, arr, r - 1);
    }

    public static void main(String[] args) {
        sum(3, 0);
        System.out.println("Sum : "+ sum(3));

        System.out.println("Sum of factorial: " + fact(5));

        int[] arr = {4, 3, 2, 1, 0};
        reverse(0, arr, arr.length - 1);  // Corrected to use arr.length - 1

        for (int num : arr) {
            System.out.print(num + " ");  // Corrected to print the elements directly
        }
    }

}