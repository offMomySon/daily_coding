package taskjob_1.v3.command;

import lombok.NonNull;
import taskjob_1.v3.aggregator.TaskCounter;
import taskjob_1.v3.domian.Task;
import taskjob_1.v3.pool.HashedTaskPool;
import taskjob_1.v3.pool.TaskPool;

public class ExecuteCommand implements Command {
    private final TaskCounter executeFailCounter;
    private final Task task;

    public ExecuteCommand(@NonNull Task task, @NonNull TaskCounter executeFailCounter) {
        this.executeFailCounter = executeFailCounter;
        this.task = task;
    }

    @Override
    public void execute(@NonNull TaskPool usablePool, @NonNull HashedTaskPool actablePool){
        if(actablePool.notContain(task)){
            executeFailCounter.increase(task);
            return ;
        }

        actablePool.remove(task);
        usablePool.add(task);
    }
}
