package taskjob_2.command;

import lombok.NonNull;
import taskjob_2.Task;
import taskjob_2.aggregator.TaskCounter;
import taskjob_2.pool.HashedTaskPool;
import taskjob_2.pool.TaskPool;

/**
 * execute command 가 수행해야하는 책임을 가진 객체.
 */
public class ExecuteCommand implements Command{
    private final TaskCounter failTaskCounter;
    private final Task requestTask;

    public ExecuteCommand(@NonNull TaskCounter failTaskCounter, @NonNull Task requestTask) {
        this.failTaskCounter = failTaskCounter;
        this.requestTask = requestTask;
    }

    @Override
    public void execute(@NonNull TaskPool taskPool, @NonNull HashedTaskPool hashedTaskPool) {
        if(hashedTaskPool.notContains(requestTask)){
            failTaskCounter.increase(requestTask);
            return;
        }

        hashedTaskPool.getExecutableTask(requestTask)
            .ifPresent(taskPool::addUsableTask);

    }
}
