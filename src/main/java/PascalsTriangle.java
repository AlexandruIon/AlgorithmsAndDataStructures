import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> listOfRows = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        listOfRows.add(firstRow);

        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> previousRow = listOfRows.get(i);
            for (int j = 0; j < previousRow.size() - 1; j++) {
                row.add(previousRow.get(j) + previousRow.get(j + 1));
            }
            row.add(1);
            listOfRows.add(row);
        }
        return listOfRows;
    }

}
