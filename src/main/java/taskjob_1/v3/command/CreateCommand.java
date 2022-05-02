package taskjob_1.v3.command;

import lombok.NonNull;
import taskjob_1.v3.aggregator.Counter;
import taskjob_1.v3.domian.Task;
import taskjob_1.v3.pool.HashedTaskPool;
import taskjob_1.v3.pool.TaskPool;

public class CreateCommand implements Command{
    private final Counter createFailCounter;

    public CreateCommand(@NonNull Counter createFailCounter) {
        this.createFailCounter = createFailCounter;
    }

    @Override
    public void execute(@NonNull TaskPool usablePool, @NonNull HashedTaskPool actablePool) {
        if(usablePool.isEmpty()){
            createFailCounter.increase();
            return;
        }

        Task task = usablePool.poll();
        actablePool.add(task);
    }
}
