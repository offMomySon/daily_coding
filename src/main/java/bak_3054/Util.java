package bak_3054;

import java.util.stream.IntStream;

public class Util {
    public static IntStream poolRange(int index) {
        return IntStream.rangeClosed((index - 1) * 4 + 1, index * 4 + 1);
    }

    public static IntStream cmdRange(String cmd) {
        return IntStream.rangeClosed(1, cmd.length());
    }

    public static IntStream range(String cmd) {
        return IntStream.rangeClosed(1, cmd.length() * 4 + 1);
    }
}
