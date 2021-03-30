package old.c151;

class Solution {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");

        int len = strings.length;

        StringBuilder builder = new StringBuilder();

        for (int i = len - 1; i >= 0; i --) {
            if (strings[i].equals("")) {
                continue;
            }
            builder.append(strings[i]);
            if(i != 0) {
                builder.append(" ");
            }
        }

        return builder.toString().trim();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.reverseWords("  hello world!  ");
    }
}