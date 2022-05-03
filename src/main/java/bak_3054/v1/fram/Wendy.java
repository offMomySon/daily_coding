package bak_3054.v1.fram;

import java.util.Objects;

public class Wendy implements Frame {
    private static final String general = ".";
    private static final String special = "*";
    private final String ch;

    public Wendy(String ch) {
        this.ch = validate(ch);
    }

    public static Wendy from(char ch) {
        return new Wendy(ch + "");
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
