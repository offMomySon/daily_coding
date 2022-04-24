package bak_3054.v2.printer;

import bak_3054.v2.frame.Line;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LinePrinter implements Printer {
    private final List<Line> lines;

    public LinePrinter(List<Line> lines) {
        this.lines = validate(lines);
    }

    private List<Line> validate(List<Line> lines) {
        if (Objects.isNull(lines)) {
            throw new RuntimeException("pool factory 가 null 입니다.");
        }

        List<Line> newLines = lines.stream().filter(Objects::nonNull).collect(
            Collectors.toUnmodifiableList());

        if (newLines.isEmpty()) {
            throw new RuntimeException("pool factory 가 empty 입니다.");
        }

        return newLines;
    }
    
    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        for (Line line : lines) {
            sb.append(line.getLine()).append("\n");
        }

        System.out.println(sb);
    }
}
