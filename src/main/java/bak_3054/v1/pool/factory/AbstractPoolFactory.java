package bak_3054.v1.pool.factory;

import bak_3054.v1.fram.Frame;
import bak_3054.v1.pool.FramePool;
import bak_3054.v1.pool.Pool;
import java.util.function.Function;
import static bak_3054.Util.poolRange;

public abstract class AbstractPoolFactory implements PoolFactory {
    protected Pool create(int index, char ch, Function<Character, Frame> frameCreator) {
        FramePool pool = new FramePool();

        poolRange(index)
            .filter(n -> !pool.contain(n))
            .forEach(n -> pool.add(n, frameCreator.apply(ch)));

        return pool;
    }
}
