package old.c709;

class Solution {
    public String toLowerCase(String str) {

        char[] chars = str.toCharArray();

        int length = chars.length;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < length; i ++) {
            char c = chars[i];
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c + 32);
            }
            buffer.append(c);
        }

        return buffer.toString();

    }

    public static void main(String[] args) {

        System.out.println('a' - 'A');
        Solution s = new Solution();

        String hello = s.toLowerCase("Hello");
        System.out.println(hello);
    }
}