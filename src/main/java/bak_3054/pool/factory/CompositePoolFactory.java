package bak_3054.pool.factory;

import bak_3054.pool.CompositedFramePool;
import bak_3054.pool.Pool;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompositePoolFactory extends AbstractPoolFactory {
    private final List<PoolFactory> poolFactories;

    public CompositePoolFactory(List<PoolFactory> poolFactories) {
        this.poolFactories = validate(poolFactories);
    }

    public static CompositePoolFactory of(PoolFactory... poolFactory) {
        return new CompositePoolFactory(Stream.of(poolFactory).collect(Collectors.toList()));
    }

    private List<PoolFactory> validate(List<PoolFactory> poolFactories) {
        if (Objects.isNull(poolFactories)) {
            throw new RuntimeException("pool factory 가 null 입니다.");
        }

        List<PoolFactory> newPoolFactory = poolFactories.stream().filter(Objects::nonNull).collect(
            Collectors.toUnmodifiableList());
        
        if (newPoolFactory.isEmpty()) {
            throw new RuntimeException("pool factory 가 empty 입니다.");
        }

        return newPoolFactory;
    }

    @Override
    public Pool create(String cmd) {
        return new CompositedFramePool(poolFactories.stream()
                                           .map(fac -> fac.create(cmd))
                                           .collect(Collectors.toList()));
    }
}
