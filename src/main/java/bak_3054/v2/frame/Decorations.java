package bak_3054.v2.frame;

import bak_3054.v2.decorate.Decoration;
import java.util.List;
import lombok.NonNull;

public class Decorations {
    private final List<Decoration> decorations;

    public Decorations(@NonNull List<Decoration> decorations) {
        this.decorations = decorations;
    }

    public Line merge(List<FrameLine> lines) {
        StringBuilder sb = new StringBuilder();

        Decoration prevDec = decorations.get(0);
        Line prevLine = lines.get(0);

        sb.append(prevLine.getLine());

        for (int i = 1; i < lines.size(); i++) {
            Decoration postDec = decorations.get(i);

            boolean isPostUpper = prevDec.compareTo(postDec) < 0;

            if (isPostUpper) {
                sb.deleteCharAt(sb.length() - 1);
                sb.append(lines.get(i).getLine());
            } else {
                String postLineDeletedOneChar = lines.get(i).getLine().substring(1);
                sb.append(postLineDeletedOneChar);
            }

            prevDec = decorations.get(i);
        }

        return new SimpleLine(sb.toString());
    }
}
