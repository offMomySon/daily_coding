package bak_10796.v1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 도메인 객체인 라인을 이용해서 '세로 문자열 집합' 개념을 다루는 역할.
 *
 *  1. line 을 입려받고 세로 문자열들에 추가 하는 역할
 *  2. 세로 문자열들을 하나의 가로 문자열로 생성하는 역할
 */
public class Columns {
    private List<Line> cols;

    public Columns() {
        this.cols = new LinkedList<>();
    }

    public void add(Line row){
        syncColumSize(row);
        doAdd(row);
    }

    private void syncColumSize(Line row){
        while(cols.size() < row.size()){
            cols.add(Line.EMPTY());
        }
    }

    private void doAdd(Line row){
        Iterator<Line> iterator = cols.iterator();

        while(row.hasNext()){
            String sChar = row.poll();

            if(!iterator.hasNext()){
                throw new RuntimeException("size 잘못됨.");
            }

            Line col = iterator.next();
            col.add(sChar);
        }
    }

    public Line createRow(){
        return cols.stream().reduce(Line.EMPTY(), Line::append);
    }

    @Override
    public String toString() {
        return "Columns{" +
            "columns=" + cols +
            '}';
    }
}
