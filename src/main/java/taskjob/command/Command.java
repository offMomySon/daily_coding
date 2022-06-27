package taskjob.command;

import lombok.NonNull;
import taskjob.pool.HashedTaskPool;
import taskjob.pool.TaskPool;

public interface Command {
    void act(@NonNull TaskPool creatableTaskPool, @NonNull HashedTaskPool executableTaskPool);
}
