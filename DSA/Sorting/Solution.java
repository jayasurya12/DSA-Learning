// import java.util.*;

// public class Test {
//     static int countFactors(int n) {
//         int count = 0;
//         for (int i = 1; i <= Math.sqrt(n); i++) {
//             if (n % i == 0) {
//                 if (n / i == i) {
//                     count++;
//                 } else {
//                     count += 2;
//                 }
//             }
//         }
//         return count;
//     }

//     static int[] solve(int[] A) {
//         Integer[] indices = new Integer[A.length];
//         for (int i = 0; i < A.length; i++) {
//             indices[i] = i;
//         }
//         System.out.print(Arrays.toString(indices));
//         Arrays.sort(indices, (a, b) -> {
//             System.out.println(a +":"+ b);
//             int countA = countFactors(A[a]);
//             int countB = countFactors(A[b]);
//             if (countA == countB) {
//                 return A[a] - A[b];
//             }
//             return countA - countB;
//         });

//         int[] result = new int[A.length];
//         for (int i = 0; i < A.length; i++) {
//             result[i] = A[indices[i]];
//         }

//         return result;
//     }
//     public static void main(String [] args) {
//         int [] arr = {6, 8, 9};
//         String ans = Arrays.toString(solve(arr));
//         System.out.println(ans);
//     }
// }


public class Solution {
    public static int tens(int num) {
       return (num / 10) % 10;
    }
    public int[] solve(int[] A) {
        Integer[] indices = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            indices[i] = i;
        }

        // Sort based on the number of occurrences of 10
        Arrays.sort(indices, (a, b) -> {
            int countA = tens(A[a]);
            int countB = tens(A[b]);
            if (countA == countB) {
                return A[b] - A[a]; // Sort by value if counts are equal
            }
            return countA - countB; // Sort by descending count of tens
        });

        // Create a result array with sorted elements
        int[] sortedArray = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            sortedArray[i] = A[indices[i]];
        }
        return sortedArray;
    }
}