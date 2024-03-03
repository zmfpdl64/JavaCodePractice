package programers.카카오2023;

/*
표

셀의 크기
1 ~ 50

Update 방식
1. row, col value
    특정 셀 변경
2. value1 value2
    특정 값 변경 (완탐)

Merge 방식
row1, col2, row2, col2
1. 둘 중에 하나만 값이 존재 시 해당 값
2. 둘 다 있으면 첫번 째 셀 값

UnMerge 방식
row, col 중첩되어 있는 병합 해제
같은 구간으로 이뤄져 있는 구간 null And 해당 셀은 값 가지고 있음
-> 원본, 업데이트 자료구조 필요 없음

*/
import java.util.*;

class 표병합 {
    public static void main(String[] args) {
//        String[] ins = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
        String[] ins = {"MERGE 1 1 2 2",
                "UPDATE 1 1 A",
                "UNMERGE 1 1",
                "PRINT 1 1",
                "PRINT 2 2"};
        for(String i: solution(ins)){
            System.out.println(i);
        }
    }
    public static String[] solution(String[] commands) {
        List<String> answer = new LinkedList<>();

        Cell[][] cells = new Cell[51][51];
        boolean[][] viMap = new boolean[51][51];

        for(int i = 0; i < viMap.length; i++) {
            Arrays.fill(viMap[i], false);
        }

        for(int i = 0; i < 51; i++) {
            for(int j = 0; j < 51; j++){
                cells[i][j] = new Cell(i, j);
            }
        }

        for(String command: commands) {
            String[] _cmd = command.split(" ");
            int row;
            int col;
            if(_cmd[0].equals("UPDATE")){
                if(_cmd.length > 3) {
                    row = Integer.parseInt(_cmd[1]);
                    col = Integer.parseInt(_cmd[2]);
                    cells[row][col].update(_cmd[3], getViMap(viMap));
                }else{
                    for(int i = 0; i < cells.length; i++) {
                        for(int j = 0; j < cells[i].length; j++) {
                            if(cells[i][j].value != null && cells[i][j].value.equals(_cmd[1])) {
                                cells[i][j].value = _cmd[2];
                            }
                        }
                    }
                }
            }
            else if(_cmd[0].equals("MERGE")){
                row = Integer.parseInt(_cmd[1]);
                col = Integer.parseInt(_cmd[2]);
                int row2 = Integer.parseInt(_cmd[3]);
                int col2 = Integer.parseInt(_cmd[4]);
                cells[row][col].merge(cells[row2][col2], getViMap(viMap));

            }else if(_cmd[0].equals("UNMERGE")){
                row = Integer.parseInt(_cmd[1]);
                col = Integer.parseInt(_cmd[2]);
                String value = cells[row][col].value;
                cells[row][col].unMerge(getViMap(viMap));
                cells[row][col].update(value, getViMap(viMap));
            }else if(_cmd[0].equals("PRINT")){
                row = Integer.parseInt(_cmd[1]);
                col = Integer.parseInt(_cmd[2]);
                answer.add(cells[row][col].print());
            }
        }
        return answer.stream().toArray(String[]::new);
    }



    public static boolean[][] getViMap(boolean[][] viMap) {
        boolean[][] _viMap = new boolean[viMap.length][viMap[0].length];
        for(int i = 0; i < viMap.length; i++) {
            Arrays.fill(_viMap[i], false);
        }
        return _viMap;
    }
}

class Cell {
    int row;
    int col;
    String value;
    List<Cell> graph = new LinkedList<>();

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void update(String value, boolean[][] viMap) {
        this.value = value;
        for(Cell next: graph) {
            if(!viMap[next.row][next.col]) {
                viMap[next.row][next.col] = true;
                next.update(value, viMap);
            }
        }
    }
    public void merge(Cell cell, boolean[][] viMap) {
        if(this.value != null) {
            cell.update(this.value, viMap);
            this.update(cell.value, viMap);
        }else{
            this.update(cell.value, viMap);
            cell.update(this.value, viMap);
        }


        graph.add(cell);
        cell.graph.add(this);
    }
    public void unMerge(boolean[][] viMap) {
        for(Cell next: graph) {
            if(!viMap[next.row][next.col]){
                viMap[next.row][next.col] = true;
                next.value = null;
                next.unMerge(viMap);
            }
        }
        this.graph.clear();
    }

    public String print() {
        if(value == null) return "EMPTY";
        return value;
    }
}
