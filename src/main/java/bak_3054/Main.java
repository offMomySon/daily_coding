package bak_3054;

import bak_3054.pool.Pool;
import bak_3054.pool.factory.CompositePoolFactory;
import bak_3054.pool.factory.PeterpanFramePoolFactory;
import bak_3054.pool.factory.WendyPoolFactory;
import bak_3054.printer.CharacterLine;
import bak_3054.printer.EdgeLine;
import bak_3054.printer.Printer;
import bak_3054.printer.SandwichLine;
import bak_3054.printer.SequenceLinePrinter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    private static MyReader mr = new MyReader();

    public static void main(String[] args) {

        String cmd = mr.next();

        Pool pool = CompositePoolFactory.of(new WendyPoolFactory(), new PeterpanFramePoolFactory()).create(cmd);


        // 배수가 변화 가능하다.
        // input 이 변할 수 있다.
        // 프레인이 추가 될 수 있다.
        // 순서가 변할 수 있다.
        Printer printer = new SequenceLinePrinter.Builder()
            .nextPrinter(new EdgeLine())
            .nextPrinter(new SandwichLine())
            .nextPrinter(new CharacterLine())
            .nextPrinter(new SandwichLine())
            .nextPrinter(new EdgeLine())
            .build();

        printer.print(cmd, pool);
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
