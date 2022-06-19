package taskjob_2.command;

import lombok.NonNull;
import taskjob_2.Counter;
import taskjob_2.HashTaskPool;
import taskjob_2.Task;
import taskjob_2.TreeTaskPool;

public class CreateCommand implements Command{

    private final Counter failCounter;

    public CreateCommand(@NonNull Counter failCounter) {
        this.failCounter = failCounter;
    }

    @Override
    public void execute(@NonNull TreeTaskPool usablePool, @NonNull HashTaskPool executePool) {
        if(usablePool.notLeft()){
            failCounter.increase();
            return;
        }

        Task task = usablePool.pull();
        executePool.push(task);
    }
}
