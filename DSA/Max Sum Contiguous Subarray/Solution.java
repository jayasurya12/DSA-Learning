class Solution {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 }; // Example input array
        Solution solution = new Solution(); // Create an instance of Solution
        int maxSum = solution.maxSubArray(arr); // Call the method to find the maximum subarray sum
        System.out.print(maxSum); // Print the result
    }
    
    public int maxSubArray(final int[] arr) {
        int sum = 0;
        int ans = Integer.MIN_VALUE; // Corrected typo in Integer.MIN_VALUE
        for (int i = 0; i < arr.length; ++i) { // Start the loop from index 0
            sum += arr[i];
            ans = Math.max(sum, ans);
            if (sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
}
