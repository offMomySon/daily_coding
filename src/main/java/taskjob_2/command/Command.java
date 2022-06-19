package taskjob_2.command;

import java.util.PriorityQueue;
import lombok.NonNull;
import taskjob_2.Task;
import taskjob_2.pool.HashTaskPool;
import taskjob_2.pool.TreeTaskPool;

public interface Command {
    void execute(@NonNull PriorityQueue<Task> usablePool, @NonNull HashTaskPool executePool);
}
