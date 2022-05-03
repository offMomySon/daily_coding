package bak_3054.v2.frame;

import bak_3054.v2.decorate.Decoration;
import lombok.NonNull;

public class OneTermPeriodicalDecorateLine extends FrameLine {

    public OneTermPeriodicalDecorateLine(@NonNull String value) {
        super(value);
    }

    public static OneTermPeriodicalDecorateLine from(@NonNull Decoration decoration) {
        String decorator = decoration.getValue();

        return new OneTermPeriodicalDecorateLine("." + decorator + "." + decorator + ".");
    }

    public String getLine() {
        return value;
    }
}
