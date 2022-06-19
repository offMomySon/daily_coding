package taskjob_2.command;

import lombok.NonNull;
import taskjob_2.HashTaskPool;
import taskjob_2.Task;
import taskjob_2.TaskCounter;
import taskjob_2.TreeTaskPool;

public class ExecuteCommand implements Command{
    private final TaskCounter failTaskCounter;
    private final Task task;

    public ExecuteCommand(@NonNull TaskCounter failTaskCounter, @NonNull Task task) {
        this.failTaskCounter = failTaskCounter;
        this.task = task;
    }

    @Override
    public void execute(@NonNull TreeTaskPool usablePool, @NonNull HashTaskPool executablePool) {
        if(executablePool.notExist(task)){
            failTaskCounter.increase(task);
            return;
        }

        Task executableTask = executablePool.get(task);
        usablePool.add(executableTask);
    }
}
