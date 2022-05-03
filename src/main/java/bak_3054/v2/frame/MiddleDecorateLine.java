package bak_3054.v2.frame;

import bak_3054.v2.decorate.Decoration;
import lombok.NonNull;

// line format 을 나누는것.
public class MiddleDecorateLine extends FrameLine {
    private static final String line = "..%s..";

    public MiddleDecorateLine(@NonNull String value) {
        super(value);
    }

    public static MiddleDecorateLine from(@NonNull Decoration decoration) {
        String decorator = decoration.getValue();
        return new MiddleDecorateLine(".." + decorator + "..");
    }

    public String getLine() {
        return value;
    }
}
