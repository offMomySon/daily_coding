package bak_3054.v2.view;

import bak_3054.v2.decorate.Decoration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static bak_3054.v2.decorate.Decoration.BLANK;

public class OverlapDecorations {
    private final List<Decoration> decorations;

    protected OverlapDecorations(List<Decoration> decorations) {
        this.decorations = decorations;
    }

    public static OverlapDecorations empty() {
        return new OverlapDecorations(List.of());
    }

    public static OverlapDecorations of(Decoration... decorations) {
        return new OverlapDecorations(Arrays.asList(decorations));
    }

    public OverlapDecorations merge(OverlapDecorations otherView) {
        return new OverlapDecorations(merge(this.decorations, otherView.decorations));
    }

    private static List<Decoration> merge(List<Decoration> preDecorations, List<Decoration> postDecorations) {
        if (preDecorations.isEmpty() || postDecorations.isEmpty()) {
            return combine(preDecorations, postDecorations);
        }

        Decoration preDecorationsLast = preDecorations.get(preDecorations.size() - 1);
        Decoration postDecorationFirst = postDecorations.get(0);

        boolean isOtherFirstBigger = preDecorationsLast.compareTo(postDecorationFirst) < 0;
        List<Decoration> newPreDecorations = new ArrayList<>(//5 -> 4 , 5
                                                          preDecorations.subList(0, isOtherFirstBigger ? preDecorations.size() - 1 : preDecorations.size())
        );
        List<Decoration> newPostDecorations = new ArrayList<>(
            postDecorations.subList(isOtherFirstBigger ? 0 : 1, postDecorations.size())
        );

        return combine(newPreDecorations, newPostDecorations);
    }

    private static List<Decoration> combine(List<Decoration> decorations1, List<Decoration> decorations2) {
        List<Decoration> newDecorations = new ArrayList<>(decorations1);
        newDecorations.addAll(decorations2);

        return newDecorations;
    }

    @Override
    public String toString() {
        return this.decorations.stream().map(Decoration::toString).collect(Collectors.joining());
    }
}
