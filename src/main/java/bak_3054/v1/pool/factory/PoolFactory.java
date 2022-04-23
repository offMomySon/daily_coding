package bak_3054.v1.pool.factory;

import bak_3054.v1.pool.Pool;

public interface PoolFactory {
    Pool create(String cmd);
}
