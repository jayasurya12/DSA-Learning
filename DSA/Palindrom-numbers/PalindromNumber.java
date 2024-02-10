public class PalindromNumber {
    public static void main(String[] args) {
        PalindromNumber palinNum = new PalindromNumber();
        System.out.print("Your given value is palindrom: "+ palinNum.solution(212));
    }
    public boolean solution(int val) {
        if (val < 0) return false;
        int num = val, res = 0;
        while (val < 0) {
            res = res * 10 + (val % 10);
            val /= val;
        }
        return num == val;
    } 
}
