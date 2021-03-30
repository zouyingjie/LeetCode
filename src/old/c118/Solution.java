package old.c118;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {

        if (numRows == 0) {
            return result;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        if (numRows == 1) {
            return result;
        }
        int row = 2;

        List<Integer> lastRow = firstRow;
        while (row <= numRows) {
            List<Integer> rowList = new ArrayList<>();
            int i = 0;
            while (i < row) {
                if (i == 0 || i == (row-1)) {
                    rowList.add(1);
                }else {
                    rowList.add(lastRow.get(i-1) + lastRow.get(i));
                }
                i ++;
            }
            result.add(rowList);
            lastRow = rowList;
            row ++;
        }
        return result;

    }
}