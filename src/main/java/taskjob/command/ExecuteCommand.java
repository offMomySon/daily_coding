package taskjob.command;

import lombok.NonNull;
import taskjob.aggregator.TaskCounter;
import taskjob.pool.HashedTaskPool;
import taskjob.Task;
import taskjob.pool.TaskPool;

public class ExecuteCommand implements Command{
    private final TaskCounter taskFailCounter;
    private final Task requestTask;

    public ExecuteCommand(@NonNull TaskCounter taskFailCounter, @NonNull Task requestTask) {
        this.taskFailCounter = taskFailCounter;
        this.requestTask = requestTask;
    }

    @Override
    public void act(@NonNull TaskPool creatableTaskPool, @NonNull HashedTaskPool executableTaskPool) {
        if(executableTaskPool.notContain(requestTask)) {
            taskFailCounter.add(requestTask);
            return;
        }

        Task task = executableTaskPool.poll(requestTask).orElseThrow(()-> new RuntimeException("task not exist."));

        creatableTaskPool.add(task);
    }
}
