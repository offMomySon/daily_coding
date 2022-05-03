package taskjob_1.v2.command;

import lombok.NonNull;
import taskjob_1.v2.aggregate.ExecuteFailCounter;
import taskjob_1.v2.domain.Task;
import taskjob_1.v2.pool.CreatedTaskPool;
import taskjob_1.v2.pool.UsableTaskPool;

/**
 * execute cmd 를 받으면
 * task execute 를 실행하는 역할.
 */
public class ExecuteCommand implements Command {
    private final static String matchCmd = "execute";

    private final ExecuteFailCounter executeFailCounter;

    public ExecuteCommand(@NonNull ExecuteFailCounter executeFailCounter) {
        this.executeFailCounter = executeFailCounter;
    }

    @Override
    public void execute(String cmd, UsableTaskPool usableTaskPool, CreatedTaskPool createdTaskPool) {
        Task task = new Task(cmd.split(" ")[1]);

        if(createdTaskPool.notHas(task)){
            executeFailCounter.increase1(task);
            return;
        }

        createdTaskPool.remove(task);
        usableTaskPool.add(task);
    }

    @Override
    public boolean isExecutable(String cmd) {
        String actingCmd = cmd.split(" ")[0];

        return matchCmd.equals(actingCmd);
    }
}
