package taskjob_2.command;

import lombok.NonNull;
import taskjob_2.HashTaskPool;
import taskjob_2.TreeTaskPool;

public interface Command {
    void execute(@NonNull TreeTaskPool usablePool, @NonNull HashTaskPool executePool);
}
