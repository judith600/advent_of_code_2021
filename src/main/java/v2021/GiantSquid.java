package v2021;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import common.ReadInputUtil;

public class GiantSquid {

    private List<Integer> drawInput;
    private List<BingoField> bingoFields;

    public GiantSquid(String fileName) {
    }

    public void setDrawInput(String fileName) {
        List<String> lines = ReadInputUtil.readLines(fileName);
        drawInput = Arrays.stream(lines.get(0).split(","))
                .map(Integer::valueOf).collect(Collectors.toList());
    }

    public void setBingoFields(String fileName) {
        List<String> inputAsLineList = ReadInputUtil.readLines(fileName);
        assert inputAsLineList != null;
        inputAsLineList.removeIf(line -> line.trim().isEmpty());
        System.out.println(inputAsLineList.get(0));
        if (inputAsLineList.size() % 5 != 0) {
            throw new IllegalStateException("line size is " + inputAsLineList.size());
        }
        int k = 1;
        for (int m = 0; m < k * 5; m++) {
            Integer[] lineArray = (Integer[]) Arrays.stream(inputAsLineList.get(m).split(" "))
                    .map(Integer::valueOf).toArray();
        }
    }

    public List<Integer> getDrawInput() {
        return drawInput;
    }

    public List<BingoField> getBingoFields() {
        return bingoFields;
    }

    class BingoField {
        int[][] board;
        boolean[][] isMarked;

        public BingoField() {
            board = new int[5][5];
            isMarked = new boolean[5][5];
        }

        public boolean markNumberIfPresent(int draw) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (draw == board[i][j]) {
                        isMarked[i][j] = true;
                        boolean isRowWin = checkRowForWin(i);
                        boolean isColWin = checkColumnForWin(j);
                        return isRowWin || isColWin;
                    }
                }
            }
            return false;
        }

        private boolean checkRowForWin(int row) {
            int counter = 0;
            for (int i = 0; i < board.length; i++) {
                if (isMarked[row][i]) {
                    counter++;
                }
            }
            return counter == 5;
        }

        private boolean checkColumnForWin(int col) {
            int counter = 0;
            for (int i = 0; i < board.length; i++) {
                if (isMarked[i][col]) {
                    counter++;
                }
            }
            return counter == 5;
        }
    }
}
