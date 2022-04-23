package bak_3054.v2.frame;

import lombok.NonNull;

public class SimpleLine extends FrameLine {
    protected SimpleLine(@NonNull String value) {
        super(value);
    }

    @Override
    public String getLine() {
        return value;
    }
}
