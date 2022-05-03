package bak_10796.v1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * sChar 배열을 다루기 위한 도메인 객체
 *
 * 1. string 으로 부터 line 을 생성하는 역할
 * 2. 라인과 라인의 합성으로 새로운 라인을 만드는 역할.
 * 3. 라인에서 sChar 하나하나를 내보내는 역할
 */
public class Line {
    private final Queue<String> values;

    private Line(Queue<String> values) {
        this.values = values;
    }

    public static Line EMPTY(){
        return new Line(new LinkedList<>());
    }

    public static Line of(String input){
        LinkedList<String> strings = new LinkedList<>();

        for(char ch : input.toCharArray()){
            strings.add(String.valueOf(ch));
        }

        return new Line(strings);
    }

    public void add(String sChar){
        values.add(sChar);
    }

    public Line append(Line backWordLine){
        String forward = values.stream().reduce("", (it1, it2) -> it1 + it2);
        String backWord = backWordLine.values.stream().reduce("", (it1, it2) -> it1 + it2);

        return Line.of(forward+backWord);
    }

    public String poll(){
        return values.poll();
    }

    public boolean hasNext(){
        return !values.isEmpty();
    }

    public int size(){
        return values.size();
    }

    @Override
    public String toString() {
        return "Column{" +
            "values=" + values +
            '}';
    }
}
