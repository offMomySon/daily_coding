package bak_3054.v2.frame;

import bak_3054.v2.decorate.Decoration;
import lombok.NonNull;

public class CharactorShowLine extends FrameLine {
    private static final String line = "**%s**";

    public CharactorShowLine(@NonNull String value) {
        super(value);
    }

    public static CharactorShowLine from(@NonNull Decoration prefixDecoration, Decoration charDecoration) {
        String prefix = prefixDecoration.getValue();
        String charDecorator = charDecoration.getValue();

        return new CharactorShowLine(prefix + "." + charDecorator + "." + prefix);
    }

    public String getLine() {
        return value;
    }
}
