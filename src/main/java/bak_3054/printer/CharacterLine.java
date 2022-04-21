package bak_3054.printer;

import bak_3054.fram.Frame;
import bak_3054.pool.Pool;
import static bak_3054.Util.range;

public class CharacterLine implements Printer {
    private static boolean isOriginalCharIndex(int index) {
        return (index - 3) % 4 == 0;
    }

    private static boolean isSpecialCharIndex(int index) {
        return (index - 1) % 2 == 0;
    }

    @Override
    public void print(String cmd, Pool pool) {
        String line = range(cmd)
            .mapToObj(index -> getFrameSchar(index, pool))
            .reduce("", (it, it1) -> it + it1);

        System.out.println(line);
    }

    private static String getFrameSchar(int index, Pool pool) {
        Frame frame = pool.find(index);

        if (isOriginalCharIndex(index)) {
            return frame.getCh();
        }
        if (isSpecialCharIndex(index)) {
            return frame.getSpecial();
        }

        return frame.getGeneral();
    }
}
