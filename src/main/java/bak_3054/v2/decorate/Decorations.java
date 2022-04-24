package bak_3054.v2.decorate;

import bak_3054.v2.frame.FrameLine;
import bak_3054.v2.frame.Line;
import bak_3054.v2.frame.SimpleLine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.NonNull;

public class Decorations {
    private final List<Decoration> decorations;

    public Decorations(@NonNull List<Decoration> decorations) {
        this.decorations = decorations;
    }

    public static Decorations of(Decoration... decorations) {
        return new Decorations(Arrays.stream(decorations).collect(Collectors.toList()));
    }

//    public Decorations merge(Decorations otherDecoration) {
//        if (this.decorations.isEmpty() || otherDecoration.decorations.isEmpty()) {
//            List<Decoration> newDecorations = combine(this.decorations, otherDecoration.decorations);
//            return new Decorations(newDecorations);
//        }
//
//        Decoration thisLastDecoration = getLastDecoration();
//        Decoration otherFirstDecoration = otherDecoration.getFirstDecoration();
//
//        boolean isOtherFirstBigger = thisLastDecoration.compareTo(otherFirstDecoration) < 0;
//        List<Decoration> preDecorations = new ArrayList<>(//5 -> 4 , 5
//                                                          this.decorations.subList(0,
//                                                                                   isOtherFirstBigger ? this.decorations.size() - 1 : this.decorations.size())
//        );
//        List<Decoration> postDecorations = new ArrayList<>(
//            otherDecoration.decorations.subList(isOtherFirstBigger ? 0 : 1, otherDecoration.decorations.size())
//        );
//
//        List<Decoration> newDecorations = combine(preDecorations, postDecorations);
//
//        return new Decorations(newDecorations);
//    }

//    public Decoration poll() {
//        Decoration decoration = decorations.get(0);
//        decorations.remove(0);
//        return decoration;
//    }

    public Decoration getLastDecoration() {
        int lastIndex = this.decorations.size() - 1;
        return this.decorations.get(lastIndex);
    }

    public Decoration getFirstDecoration() {
        int firstIndex = 0;
        return this.decorations.get(firstIndex);
    }

    public List<Decoration> getDecorations() {
        return Collections.unmodifiableList(decorations);
    }

//    private static List<Decoration> combine(List<Decoration> decorations1, List<Decoration> decorations2) {
//        List<Decoration> newDecorations = new ArrayList<>(decorations1);
//        newDecorations.addAll(decorations2);
//
//        return newDecorations;
//    }

    @Override
    public String toString() {
        return this.decorations.stream().map(Decoration::toString).collect(Collectors.joining());
    }
}
