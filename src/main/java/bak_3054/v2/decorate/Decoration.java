package bak_3054.v2.decorate;

import lombok.NonNull;

public class Decoration implements Comparable<Decoration> {
    public static final Decoration BLANK = new Decoration(".", -1);
    public static final Decoration wendy = new Decoration("*", 2);
    public static final Decoration piterpan = new Decoration("#", 1);

    private final String value;
    private final int priority;

    public Decoration(@NonNull String value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public static Decoration text(char value) {
        return new Decoration(String.valueOf(value), 3);
    }

    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(Decoration o) {
        return Integer.compare(this.priority, o.priority);
    }

    public String toString() {
        return value;
    }
}
