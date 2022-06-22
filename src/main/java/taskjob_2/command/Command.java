package taskjob_2.command;

import lombok.NonNull;
import taskjob_2.pool.HashedTaskPool;
import taskjob_2.pool.TaskPool;

/**
 * command 의 행위를 추상화한 역할.
 *
 * n 개의 command 를 각각의 Command 도메인 객체( create, execute )로 만들고,
 * 동일한 execute 를 수행한다.
 *
 * 데이터에 따른 행위를 하나로 일치 시켰다.
 */
public interface Command {
    void execute(@NonNull TaskPool usablePool, @NonNull HashedTaskPool executablePool);
}
