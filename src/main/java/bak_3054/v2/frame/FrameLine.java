package bak_3054.v2.frame;

import lombok.NonNull;

public abstract class FrameLine implements Line {
    protected final String value;

    protected FrameLine(@NonNull String value) {
        this.value = value;
    }
}
