package bak_3054.pool;

import bak_3054.fram.Frame;
import java.util.HashMap;
import java.util.Map;

public class FramePool implements Pool {
    private final Map<Integer, Frame> value = new HashMap<>();

    public void add(int index, Frame frame) {
        value.putIfAbsent(index, frame);
    }

    @Override
    public Frame find(int index) {
        return value.get(index);
    }

    public boolean contain(int index) {
        return value.containsKey(index);
    }
}
