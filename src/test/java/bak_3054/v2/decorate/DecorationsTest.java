package bak_3054.v2.decorate;

import bak_3054.v2.view.OverlapDecorations;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import static bak_3054.v2.decorate.Decoration.BLANK;

class DecorationsTest {
    @Test
    void test1() {
        String input = "ABCDEFEG";
        DecorationFactory factory = new DecorationFactory();
        List<Decoration> patternDecorations = factory.create(input.length());
        List<Decoration> valueDecorations = factory.create(input);

        OverlapDecorations middlePatternDecorations = createMiddlePatternOverlapDecoreation(patternDecorations);

        OverlapDecorations sidePatternDecorations = patternDecorations.stream()
            .map(this::createSidePatternDecorations)
            .reduce(OverlapDecorations.empty(), OverlapDecorations::merge);

        OverlapDecorations valuePatternDecorations = IntStream.range(0, patternDecorations.size())
            .mapToObj(idx -> createValuePatternDecorations(valueDecorations.get(idx), patternDecorations.get(idx)))
            .reduce(OverlapDecorations.empty(), OverlapDecorations::merge);


        System.out.println(middlePatternDecorations);
        System.out.println(sidePatternDecorations);
        System.out.println(valuePatternDecorations);
        System.out.println(sidePatternDecorations);
        System.out.println(middlePatternDecorations);

        //List= [A, B, C, D, E];

        // 합성원소가 주어지지 않았을때
        // A,B -> AA        // AA [C, D, E]
        // AA, C ->CCC      // CCC [D, E]
        // CCC, D -> AAAA   // AAAA [E]
        // AAAA, E -> DDDDD // DDDDD []

        // 합성원소를 외부에서 리스트와 함께 주어졌을때 (CC)
        // CC, A  ->   AA [B, C, D, E]
        // AA, B  ->   CCC [C, D, E]
        // CCC, C ->   DDD [D, E]

    }

    private OverlapDecorations createMiddlePatternOverlapDecoreation(List<Decoration> patternDecorations) {
        return patternDecorations.stream()
            .map(this::createMiddlePatternDecorations)
            .reduce(OverlapDecorations.empty(), OverlapDecorations::merge);
    }

    OverlapDecorations createMiddlePatternDecorations(Decoration decoration) {
        return OverlapDecorations.of(BLANK, BLANK, decoration, BLANK, BLANK);
    }

    OverlapDecorations createSidePatternDecorations(Decoration decoration) {
        return OverlapDecorations.of(BLANK, decoration, BLANK, decoration, BLANK);
    }

    OverlapDecorations createValuePatternDecorations(Decoration valueDecoration, Decoration patternDecoration) {
        return OverlapDecorations.of(patternDecoration, BLANK, valueDecoration, BLANK, patternDecoration);
    }

    @Test
    void test22() {
        System.out.println(Integer.compare(2, 1));
        System.out.println(Integer.compare(1, 2));
        System.out.println(Integer.compare(1, 1));
    }


    @Test
    void test3(){

        int sum = IntStream.rangeClosed(1, 10)
            .reduce(0, Integer::sum);

        int sum2 = IntStream.rangeClosed(1,10)
            .reduce(Integer::sum)
            .orElse(0);
    }

}