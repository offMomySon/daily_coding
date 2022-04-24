package taskjob_1.v2.command;

import taskjob_1.v2.pool.CreatedTaskPool;
import taskjob_1.v2.pool.UsableTaskPool;

/**
 * cmd 에 따라 실행가능한 명령어이면, 실행하는 역할.
 */
public interface Command {
    public void execute(String cmd, UsableTaskPool usableTaskPool, CreatedTaskPool createdTaskPool);

    public boolean isExecutable(String cmd);
}
