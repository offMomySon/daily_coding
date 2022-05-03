package bak_10796.v2;

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


    public static void main(String[] args) {
        Lines.Builder builder = new Lines.Builder();
        for(String line : INPUT2){
            builder.line(line);
        }
        Lines lines = builder.build();

        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < lines.getMaxLength(); col++) {
            sb.append(lines.columnLineAt(col));
        }
        String appendedColumn = sb.toString();

        System.out.println(appendedColumn);
    }
}
