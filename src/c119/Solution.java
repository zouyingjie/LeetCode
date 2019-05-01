package c119;

import java.util.ArrayList;
import java.util.List;

public class Solution {
//    List<List<Integer>> result = new ArrayList<>();
    public List<Integer> getRow(int rowIndex) {

        rowIndex += 1;
        List<Integer> firstRow = new ArrayList<>();

        firstRow.add(1);
        if (rowIndex == 1) {
            return firstRow;
        }
        int row = 2;
        List<Integer> lastRow = firstRow;
        while (row <= rowIndex) {
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
            lastRow = rowList;
            row ++;
        }
        return lastRow;

    }
}
