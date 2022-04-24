package taskjob_1.v2.command;

import lombok.NonNull;
import taskjob_1.v2.aggregate.CreateFailCounter;
import taskjob_1.v2.domain.Task;
import taskjob_1.v2.pool.CreatedTaskPool;
import taskjob_1.v2.pool.UsableTaskPool;

/**
 * create cmd 를 입력받으면,
 * task create 를 수행하는 역할.
 */
public class CreateCommand implements Command {
    private final static String matchCmd = "create";

    private final CreateFailCounter createFailCounter;

    public CreateCommand(@NonNull CreateFailCounter createFailCounter) {
        this.createFailCounter = createFailCounter;
    }

    @Override
    public void execute(String cmd, UsableTaskPool usableTaskPool, CreatedTaskPool createdTaskPool) {
        if(usableTaskPool.notHasNext()){
            createFailCounter.increase();
            return;
        }

        Task poll = usableTaskPool.poll();
        createdTaskPool.add(poll);
    }

    @Override
    public boolean isExecutable(String cmd) {
        return matchCmd.equals(cmd);
    }
}
