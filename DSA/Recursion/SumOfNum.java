class SumOfNum {
    static void sum(int num, int sum) {
        if (num < 1) {
            System.out.println(sum);
            return;
        }
        sum(num - 1, sum + num);  // Add num to sum in the recursive call
    }
    public static void main(String[] args) {
        sum(3, 0);
    }
}