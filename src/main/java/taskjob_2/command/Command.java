package taskjob_2.command;

import java.util.PriorityQueue;
import java.util.Set;
import lombok.NonNull;
import taskjob_2.Task;
import taskjob_2.pool.ExecutableTaskPool;
import taskjob_2.pool.UsableTaskPool;

/**
 * command 의 행위를 추상화한 역할.
 *
 * n 개의 command 를 각각의 Command 도메인 객체( create, execute )로 만들고,
 * 동일한 execute 를 수행한다.
 *
 * 데이터에 따른 행위를 하나로 일치 시켰다.
 */
public interface Command {
    void execute(@NonNull UsableTaskPool usablePool, @NonNull ExecutableTaskPool executablePool);
}
