const missingNumber = (A) => {
    
    let n = A.length;
    let temp = 0;

    // XOR all elements in the array
    for (let i = 0; i < n; i++) {
        temp ^= A[i];
    }

    // XOR numbers from 1 to n+2 (because two numbers are missing)
    for (let i = 1; i <= n + 2; i++) {
        temp ^= i;
    }

    // Find the rightmost set bit (position of difference)
    let pos = -1;
    for (let i = 0; i < 31; i++) {
        if ((temp & (1 << i)) != 0) { // Corrected parentheses
            pos = i;
            break;
        }
    }

    let a = 0;
    let b = 0;
    // Separate the numbers in the array based on the pos bit
    for (let i = 0; i < n; i++) {
        if ((A[i] & (1 << pos)) != 0) { // Corrected parentheses
            a ^= A[i];
        } else {
            b ^= A[i];
        }
    }

    // Separate the numbers from 1 to n+2 based on the pos bit
    for (let i = 1; i <= n + 2; i++) {
        if ((i & (1 << pos)) != 0) { // Corrected parentheses
            a ^= i;
        } else {
            b ^= i;
        }
    }

    let ans = Array(2).fill(0);
    // Assign the smaller to ans[0] and the larger to ans[1]
    if (a < b) {
        ans[0] = a;
        ans[1] = b;
    } else {
        ans[0] = b;
        ans[1] = a;
    }

    return ans;
}

const ans = missingNumber([1,2,4,5,7]);
console.log(ans);