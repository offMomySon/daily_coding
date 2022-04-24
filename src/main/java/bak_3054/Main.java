package bak_3054;

import bak_3054.v2.decorate.Decoration;
import bak_3054.v2.decorate.DecorationFactory;
import bak_3054.v2.frame.CharactorShowLine;
import bak_3054.v2.decorate.Decorations;
import bak_3054.v2.frame.FrameLine;
import bak_3054.v2.frame.Line;
import bak_3054.v2.frame.MiddleDecorateLine;
import bak_3054.v2.frame.OneTermPeriodicalDecorateLine;
import bak_3054.v2.printer.LinePrinter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static MyReader mr = new MyReader();

    public static void main(String[] args) {
        String cmd = mr.next();

//        DecorationFactory decorationFactory = new DecorationFactory();
//        List<Decoration> frames = decorationFactory.create(cmd.length());
//        List<Decoration> values = decorationFactory.create(cmd);
//
//
//        Decorations decorations = new Decorations(frames);
//
//        List<FrameLine> middleDecorateLines = IntStream.range(0, cmd.length())
//            .mapToObj(index -> MiddleDecorateLine.from(frames.get(index)))
//            .collect(Collectors.toList());
//        List<FrameLine> oneTermPeriodicalDecorateLine = IntStream.range(0, cmd.length())
//            .mapToObj(index -> OneTermPeriodicalDecorateLine.from(frames.get(index)))
//            .collect(Collectors.toList());
//        List<FrameLine> charactorShowLines = IntStream.range(0, cmd.length())
//            .mapToObj(index -> CharactorShowLine.from(frames.get(index), values.get(index)))
//            .collect(Collectors.toList());
//
//        Line mergedMiddleLine = decorations.merge(middleDecorateLines);
//        Line mergedOneTermLine = decorations.merge(oneTermPeriodicalDecorateLine);
//        Line mergedCharShowLine = decorations.merge(charactorShowLines);
//
//        LinePrinter linePrinter = new LinePrinter(
//            List.of(mergedMiddleLine, mergedOneTermLine, mergedCharShowLine, mergedOneTermLine, mergedMiddleLine));
//        linePrinter.print();

    }

    public static class MyReader {
        private final BufferedReader br;
        private StringTokenizer st;

        public MyReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public MyReader(String file) {
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                throw new RuntimeException("파일을 찾지 못했습니다.");
            }
        }

        public String next() {
            while (Objects.isNull(st) || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
