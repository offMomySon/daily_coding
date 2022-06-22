package taskjob_2.command;

import java.util.Set;
import lombok.NonNull;
import taskjob_2.aggregator.Counter;
import taskjob_2.Task;
import taskjob_2.pool.ExecutableTaskPool;
import taskjob_2.pool.UsableTaskPool;

/**
 * create command 가 수행해야하는 책임을 가진 객체.
 */
public class CreateCommand implements Command{

    private final Counter failCounter;

    public CreateCommand(@NonNull Counter failCounter) {
        this.failCounter = failCounter;
    }

    @Override
    public void execute(@NonNull UsableTaskPool usablePool, @NonNull ExecutableTaskPool executablePool) {
        if(usablePool.notLeft()){
            failCounter.increase();
            return;
        }

        Task task = usablePool.pollMinimumTask();
        executablePool.add(task);
    }
}
