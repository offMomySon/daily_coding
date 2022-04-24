package bak_3054.v2.view;

import bak_3054.v2.decorate.Decoration;
import static bak_3054.v2.decorate.Decoration.BLANK;

public class MiddlePatternLineView {
    private final OverlapDecorations overlapDecorations;

    public MiddlePatternLineView(OverlapDecorations overlapLineView) {
        this.overlapDecorations = overlapLineView;
    }

    public static MiddlePatternLineView of(Decoration pattern) {
        return new MiddlePatternLineView(OverlapDecorations.of(BLANK, BLANK, pattern, BLANK, BLANK));
    }

    public MiddlePatternLineView merge(MiddlePatternLineView middlePatternLineView) {
        return new MiddlePatternLineView(this.overlapDecorations.merge(middlePatternLineView.overlapDecorations));
    }
}
