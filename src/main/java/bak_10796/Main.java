package bak_10796;

import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final String[] INPUT1 = new String[]{
        "ABCDE",
        "abcde",
        "01234",
        "FGHIJ",
        "fghij"
    };
    private static final String[] INPUT2 = new String[]{
        "AABCDD",
        "afzz",
        "09121",
        "a8EWg6",
        "P5h3kx"
    };

    private static List<List<String>> columns  = new LinkedList<>();

    public static void main(String[] args) {
        Columns columns = new Columns();

        for(String line : INPUT2){
            Line row = Line.of(line);
            columns.add(row);
        }

        Line row = columns.createRow();

        System.out.println(row);
    }
}
