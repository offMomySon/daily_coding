package taskjob_2.command;

import java.util.PriorityQueue;
import java.util.Set;
import lombok.NonNull;
import taskjob_2.Task;
import taskjob_2.aggregator.TaskCounter;
import taskjob_2.pool.ExecutableTaskPool;
import taskjob_2.pool.UsableTaskPool;

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
    public void execute(@NonNull UsableTaskPool usablePool, @NonNull ExecutableTaskPool executablePool) {
        if(executablePool.notContains(requestTask)){
            failTaskCounter.increase(requestTask);
            return;
        }

        executablePool.remove(requestTask);
        usablePool.add(requestTask);
    }
}
