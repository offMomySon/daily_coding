package taskjob_2.command;

import java.util.PriorityQueue;
import lombok.NonNull;
import taskjob_2.pool.HashTaskPool;
import taskjob_2.Task;
import taskjob_2.TaskCounter;
import taskjob_2.pool.TreeTaskPool;

public class ExecuteCommand implements Command{
    private final TaskCounter failTaskCounter;
    private final Task task;

    public ExecuteCommand(@NonNull TaskCounter failTaskCounter, @NonNull Task task) {
        this.failTaskCounter = failTaskCounter;
        this.task = task;
    }

    @Override
    public void execute(@NonNull PriorityQueue<Task> usablePool, @NonNull HashTaskPool executablePool) {
        if(executablePool.notExist(task)){
            failTaskCounter.increase(task);
            return;
        }

        Task executableTask = executablePool.get(task);
        usablePool.add(executableTask);
    }
}
