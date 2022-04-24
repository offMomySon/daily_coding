package bak_3054.v1.pool;

import bak_3054.v1.fram.Frame;

public interface Pool {
    public Frame find(int index);

    public boolean contain(int index);
}
