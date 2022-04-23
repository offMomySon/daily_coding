package bak_3054.v1.pool.factory;

import bak_3054.v1.fram.Peterpan;
import bak_3054.v1.pool.CompositedFramePool;
import bak_3054.v1.pool.Pool;
import java.util.List;
import java.util.stream.Collectors;
import static bak_3054.Util.cmdRange;

public class PeterpanFramePoolFactory extends AbstractPoolFactory {
    private static boolean isBelongToPeterpanIndex(int n) {
        return n % 3 != 0;
    }

    @Override
    public Pool create(String cmd) {
        return new CompositedFramePool(createPeterpanPools(cmd));
    }

    private List<Pool> createPeterpanPools(String cmd) {
        return cmdRange(cmd)
            .filter(PeterpanFramePoolFactory::isBelongToPeterpanIndex)
            .mapToObj(n -> createPeterpanPool(n, cmd.charAt(n - 1)))
            .collect(Collectors.toList());
    }

    private Pool createPeterpanPool(int index, char ch) {
        return create(index, ch, (it) -> Peterpan.from(it));
    }
}
