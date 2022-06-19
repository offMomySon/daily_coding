package taskjob_2.command;

import java.util.PriorityQueue;
import java.util.Set;
import lombok.NonNull;
import taskjob_2.Task;
import taskjob_2.aggregator.TaskCounter;

public class ExecuteCommand implements Command{
    private final TaskCounter failTaskCounter;
    private final Task requestTask;

    public ExecuteCommand(@NonNull TaskCounter failTaskCounter, @NonNull Task requestTask) {
        this.failTaskCounter = failTaskCounter;
        this.requestTask = requestTask;
    }

    @Override
    public void execute(@NonNull PriorityQueue<Task> usablePool, @NonNull Set<Task> executablePool) {
        if(!executablePool.contains(requestTask)){
            failTaskCounter.increase(requestTask);
            return;
        }

        executablePool.remove(requestTask);
        usablePool.add(requestTask);
    }
}
