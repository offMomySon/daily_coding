package taskjob_2.command;

import java.util.PriorityQueue;
import java.util.Set;
import lombok.NonNull;
import taskjob_2.aggregator.Counter;
import taskjob_2.Task;

public class CreateCommand implements Command{

    private final Counter failCounter;

    public CreateCommand(@NonNull Counter failCounter) {
        this.failCounter = failCounter;
    }

    @Override
    public void execute(@NonNull PriorityQueue<Task> usablePool, @NonNull Set<Task> executePool) {
        if(usablePool.isEmpty()){
            failCounter.increase();
            return;
        }

        Task task = usablePool.poll();
        executePool.add(task);
    }
}
