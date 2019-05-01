package c415;

public class Solution {
    public String addStrings(String num1, String num2) {

        int lengthA = num1.length();
        int lengthB = num2.length();

        char[] chars = null;
        if (lengthA > lengthB) {
            chars = num1.toCharArray();
        }else {
            chars = num2.toCharArray();
        }

        int carryBit = 0;

        for (int i = lengthA-1, j = lengthB -1; i >= 0 && j >= 0; i --, j -- ) {
            int n1 = num1.charAt(i);
            int n2 = num2.charAt(j);

            int sum = n1 + n2 + carryBit;

            if (sum >= 10) {
                chars[i] = (char) (sum % 10);
                carryBit = 1;
            }else {
                chars[i] = (char) sum;
                carryBit = 0;
            }
        }
        return "";
    }
}
