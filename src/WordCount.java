import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordCount {

    private final int WORD_IN = 0;
    private final int WORD_OUT = 1;
    private int count = 0;
    // 解 1：一段基本的英文文本，组成字符为大小写字母+数字，分隔符为空格，/t，/n
    public void wordCount(String str) {
        if (str == null) {
            return;
        }

        int len = str.length();
        int index = 0;

        int state = WORD_OUT;

        for (; index < len; index ++) {

            char c = str.charAt(index);

            if ((isLetter(c) || isNum(c)) && state == WORD_OUT) {
                state = WORD_IN;
                count ++;
                continue;
            }

            if (isSeparator(c)) {
                state = WORD_OUT;
            }
        }
    }

    // 解 2：加入限制条件，连字符前后算一个
    public void wordCountWithHyphen(String str) {

        if (str == null) {
            return;
        }

        int len = str.length();
        int index = 0;

        int state = WORD_OUT;

        for (; index < len; index ++) {

            char c = str.charAt(index);

            if ((isLetter(c) || isNum(c)) && state == WORD_OUT) {
                state = WORD_IN;
                count ++;
                continue;
            }

            if (isSeparator(c)) {
                state = WORD_OUT;
                continue;
            }

            // 间隔符接换行符视为连字符，字符状态依然为在单词内
            if (isHyphen(c)) {
                if (index + 1 < len && str.charAt(index+1) == '\n') {
                    state = WORD_IN;
                    index++;
                }
            }

        }
    }

    // 解 3：对于 x+y 这种数学公式算一个
    // 公式限定：x+y 的四则运算类型默认没有空格
    private int currentIndex = 0;
    private int currentState = WORD_OUT;
    List<Character> operators = new ArrayList<>();

    public WordCount() {
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');
    }

    public int wordCountWithArithmeticExpressions(String str) {

        if (str == null) {
            return 0;
        }

        int len = str.length();
        int count = 0;
        currentIndex = 0;
        currentState = WORD_OUT;


        for (; currentIndex < len; currentIndex ++) {

            char c = str.charAt(currentIndex);

            if (isLetter(c) && currentState == WORD_OUT) {
                enterWord();
                count = countIncrement(count);
                continue;
            }

            if (isSeparator(c)) {
                exitWord();
                continue;
            }

            // 间隔符接换行符视为连字符，字符状态依然为在单词内
            if (isHyphen(c)) {
                if (currentIndex + 1 < len && str.charAt(currentIndex+1) == '\n') {
                    enterWord();
                    currentIndex++;
                }
                continue;
            }

            // 数字判断
            if (isNum(c)) {
                if (currentState == WORD_OUT){
                    enterWord();
                    count = countIncrement(count);
                }

                if (currentIndex + 1 < len && isOperator(str.charAt(currentIndex+1))) {
                    enterWord();
                }
            }
        }
        return count;
    }

    private void enterWord() {
        currentState = WORD_IN;
    }

    private void exitWord() {
        currentState = WORD_OUT;
    }

    private int countIncrement(int count) {
        return ++count;
    }

    private boolean isOperator(char c) {
        return operators.contains(c);
    }

    private boolean isSeparator(char c) {
        return (c == ' ' || c == '\n' || c == '\t');
    }

    private boolean isLetter(char c) {
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
    }

    private boolean isNum(char c) {
        return ((c >= '0' && c <= '9'));
    }

    private boolean isHyphen(char c) {
        return c == '-';
    }

    public static void main(String[] args) throws IOException {

        WordCount wordCount = new WordCount();
        WordCount wordCount2 = new WordCount();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/zouyingjie/Desktop/test.txt")));
        String str = null;
        int count = 0;
        while ((str = reader.readLine()) != null) {
            wordCount.wordCountWithHyphen(str);
            count += wordCount2.wordCountWithArithmeticExpressions(str);
        }

        System.out.println(wordCount.count);
        System.out.println(count);
    }
}
