package taskjob_2.command;

import java.util.PriorityQueue;
import lombok.NonNull;
import taskjob_2.Counter;
import taskjob_2.pool.HashTaskPool;
import taskjob_2.Task;
import taskjob_2.pool.TreeTaskPool;

public class CreateCommand implements Command{

    private final Counter failCounter;

    public CreateCommand(@NonNull Counter failCounter) {
        this.failCounter = failCounter;
    }

    @Override
    public void execute(@NonNull PriorityQueue<Task> usablePool, @NonNull HashTaskPool executePool) {
        if(usablePool.isEmpty()){
            failCounter.increase();
            return;
        }

        Task task = usablePool.poll();
        executePool.push(task);
    }
}
