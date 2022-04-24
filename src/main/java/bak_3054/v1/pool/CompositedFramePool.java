package bak_3054.v1.pool;

import bak_3054.v1.fram.Frame;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompositedFramePool implements Pool {
    private final List<Pool> framePools;

    public CompositedFramePool(List<Pool> framePools) {
        this.framePools = validate(framePools);
    }

    public static CompositedFramePool of(FramePool... framePools) {
        return new CompositedFramePool(Stream.of(framePools).collect(Collectors.toList()));
    }

    private List<Pool> validate(List<Pool> pools) {
        if (Objects.isNull(pools)) {
            throw new RuntimeException("pool factory 가 null 입니다.");
        }

        List<Pool> newPools = pools.stream().filter(Objects::nonNull).collect(
            Collectors.toUnmodifiableList());


        return newPools;
    }

    public boolean contain(int index) {
        return framePools.stream()
            .anyMatch(it -> it.contain(index));
    }

    public Frame find(int index) {
        return framePools.stream()
            .filter(it -> it.contain(index))
            .findFirst()
            .map(it -> it.find(index))
            .orElseThrow(() -> new RuntimeException("index 가 존재하지 않습니다. index = `" + index + "`"));
    }
}
