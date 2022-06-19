package taskjob_2.command;

import java.util.PriorityQueue;
import java.util.Set;
import lombok.NonNull;
import taskjob_2.aggregator.Counter;
import taskjob_2.Task;

/**
 * create command 가 수행해야하는 책임을 가진 객체.
 */
public class CreateCommand implements Command{

    private final Counter failCounter;

    public CreateCommand(@NonNull Counter failCounter) {
        this.failCounter = failCounter;
    }

    @Override
    public void execute(@NonNull PriorityQueue<Task> usablePool, @NonNull Set<Task> executablePool) {
        if(usablePool.isEmpty()){
            failCounter.increase();
            return;
        }

        Task task = usablePool.poll();
        executablePool.add(task);
    }
}
