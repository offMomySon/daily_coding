package bak_10796.v2;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.NonNull;

public class Lines {
    private final List<String> lines;
    private final int maxLength;

    public Lines(@NonNull List<String> lines, int maxLength) {
        this.lines = validateLine(lines);
        this.maxLength = validateMaxLength(maxLength);
    }

    private List<String> validateLine(List<String> lines){
        if(Objects.isNull(lines)){
            throw new RuntimeException("null 입니다.");
        }
        return lines.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    private int validateMaxLength(int maxLength){
        if(maxLength <= 0){
            throw new RuntimeException("maxLength 가 0 이하 입니다.");
        }
        return maxLength;
    }

    public static Lines create(@NonNull List<String> lines){
        int maxLength = lines.stream().mapToInt(l -> l.length()).max().orElseThrow(()->new RuntimeException("line 이 empty 입니다."));
        return new Lines(lines, maxLength);
    }

    public int getMaxLength(){
        return maxLength;
    }

    public String columnLineAt(int th){
        return lines.stream()
            .filter(l -> th < l.length())
            .map(l -> String.valueOf(l.charAt(th)))
            .collect(Collectors.joining());
    }

    public static class Builder{
        private List<String> lines = new LinkedList<>();

        public Builder line(String line){
            lines.add(line);
            return this;
        }

        public Lines build(){
            return Lines.create(lines);
        }
    }
}
