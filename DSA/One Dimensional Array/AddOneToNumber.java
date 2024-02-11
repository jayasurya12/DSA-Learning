import java.util.ArrayList;

class AddOneToNumber {
    public static void main(String[] args) {
        AddOneToNumber solution = new AddOneToNumber();
        ArrayList<Integer> value = new ArrayList<>();
        value.add(1);
        value.add(2);
        value.add(3);
        value.add(9);
        ArrayList<Integer> result = solution.plusOne(value);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
        }
    }
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int carry = 1;
        while (!A.isEmpty() && A.get(0) == 0) { // In 0th position is value 0 mean we remove ex: 004321, 4321. 
            A.remove(0);
        }
        for(int i = A.size()-1; i >= 0; --i) {
            int num = A.get(i);
            int sum = num + carry;
            A.set(i, sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) { //when ever the array is [0] this like that time we change [1].
            A.add(0, carry);
        }
        return A;
    }
}