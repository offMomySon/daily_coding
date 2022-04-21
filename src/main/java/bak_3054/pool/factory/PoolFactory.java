package bak_3054.pool.factory;

import bak_3054.pool.Pool;

public interface PoolFactory {
    Pool create(String cmd);
}
