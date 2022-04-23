package bak_3054.v1.pool.factory;

import bak_3054.v1.fram.Wendy;
import bak_3054.v1.pool.CompositedFramePool;
import bak_3054.v1.pool.Pool;
import java.util.List;
import java.util.stream.Collectors;
import static bak_3054.Util.cmdRange;

public class WendyPoolFactory extends AbstractPoolFactory {
    private static boolean isBelongToWendyIndex(int n) {
        return n % 3 == 0;
    }

    @Override
    public Pool create(String cmd) {
        return new CompositedFramePool(createWendyPools(cmd));
    }

    private List<Pool> createWendyPools(String cmd) {
        return cmdRange(cmd)
            .filter(WendyPoolFactory::isBelongToWendyIndex)
            .mapToObj(n -> createWendyPool(n, cmd.charAt(n - 1)))
            .collect(Collectors.toList());
    }

    private Pool createWendyPool(int index, char ch) {
        return create(index, ch, (it) -> Wendy.from(it));
    }
}
