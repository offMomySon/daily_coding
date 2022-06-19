package taskjob_2.command;

import java.util.PriorityQueue;
import java.util.Set;
import lombok.NonNull;
import taskjob_2.Task;

public interface Command {
    void execute(@NonNull PriorityQueue<Task> usablePool, @NonNull Set<Task> executePool);
}
