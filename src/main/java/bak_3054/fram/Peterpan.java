package bak_3054.fram;

import java.util.Objects;

public class Peterpan implements Frame {
    private static final String general = ".";
    private static final String special = "#";
    private final String ch;

    private Peterpan(String ch) {
        this.ch = validate(ch);
    }

    public static Peterpan from(char ch) {
        return new Peterpan(ch + "");
    }

    private String validate(String cmd) {
        if (Objects.isNull(cmd)) {
            throw new RuntimeException("cmd 가 null 입니다.");
        }
        return cmd;
    }

    @Override
    public String getCh() {
        return ch;
    }

    @Override
    public String getSpecial() {
        return special;
    }

    @Override
    public String getGeneral() {
        return general;
    }
}
