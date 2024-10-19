public public class BitManipulation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 3, 5, 8, 2, 4};
        int n = arr.length;
        int ans = 0;

        // Step 1: XOR all elements to get XOR of the two unique elements
        for (int i = 0; i < n; i++) {
            ans ^= arr[i];
        }

        // Step 2: Find the rightmost set bit in the XOR result
        int pos = 0;
        while ((ans & (1 << pos)) == 0) {
            pos++;
        }

        // Step 3: Split the array elements into two groups based on the set bit at position `pos`
        int set = 0, unSet = 0;
        for (int i = 0; i < n; i++) {
            if ((arr[i] & (1 << pos)) != 0) {
                set ^= arr[i];  // XOR for group with set bit at `pos`
            } else {
                unSet ^= arr[i];  // XOR for group with unset bit at `pos`
            }
        }

        // Output the two unique elements
        System.out.println("The two unique elements are: " + set + " and " + unSet);
    }
}
