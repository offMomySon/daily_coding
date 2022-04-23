package bak_3054.v2.decorate;

import lombok.NonNull;

public class Decoration implements Comparable<Decoration> {
    public static final Decoration wendy = highPriority("*");
    public static final Decoration piterpan = lowPriority("#");

    private final String value;
    private final int priority;

    public Decoration(@NonNull String value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public static Decoration highPriority(String value) {
        return new Decoration(value, 2);
    }

    public static Decoration lowPriority(String value) {
        return new Decoration(value, 1);
    }

    public String getValue() {
        return value;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Decoration o) {
        return Integer.compare(this.priority, o.getPriority());
    }
}
