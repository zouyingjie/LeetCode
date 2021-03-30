package old.c139;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private String s;
    private List<String> wordDict;
    private boolean result = false;
    private int length = 0;

    public boolean wordBreak(String s, List<String> wordDict) {

        this.s = s;
        this.wordDict = wordDict;
        this.length = wordDict.size();

        this.helper(s, 0);

        return result;


    }

    private void helper(String s, int index) {
        if (s.replace("_", "").length() == 0 || wordDict.contains(s.replace("-", ""))) {
            this.result = true;
            return;
        }
        if (index >= this.length) {
            return;
        }

        String word = wordDict.get(index);
        index ++;


        if (s.contains(word)) {
            helper(s.replace(word, "_"), index);
        }
        helper(s, index);

    }

    public static void main(String[] args) {
        String s = "cars";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("car");
        wordDict.add("ca");
        wordDict.add("rs");

        Solution solution = new Solution();
        boolean b = solution.wordBreak(s, wordDict);

    }

}