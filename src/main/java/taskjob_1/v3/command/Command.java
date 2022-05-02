package taskjob_1.v3.command;

import lombok.NonNull;
import taskjob_1.v3.pool.HashedTaskPool;
import taskjob_1.v3.pool.TaskPool;

public interface Command {
    void execute(@NonNull TaskPool usablePool, @NonNull HashedTaskPool actablePool);
}
