package taskjob;

import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import taskjob.aggregator.Counter;
import taskjob.command.CreateCommand;
import taskjob.pool.HashedTaskPool;
import taskjob.pool.TaskPool;

class CreateCommandTest {

    @DisplayName("creatable pool 에서 task 가 제거되고, 제거된 task 가 executable pool 에 추가됩니다.")
    @Test
    void test1(){
        //given
        TaskPool creatableTaskPool = TaskPool.of(List.of(Task.from("1")));
        HashedTaskPool executableTaskPool = HashedTaskPool.empty();
        CreateCommand command = new CreateCommand(new Counter(0));

        //when
        command.act(creatableTaskPool, executableTaskPool);
        boolean actual = creatableTaskPool.isEmpty();

        //then
        Assertions.assertThat(actual)
            .isTrue();
    }

    @DisplayName("creatable pool 가 비어있으면, executable pool 에 추가되지 않습니다.")
    @Test
    void test2(){
        //given
        TaskPool creatableTaskPool = TaskPool.of(Collections.emptyList());
        HashedTaskPool executableTaskPool = HashedTaskPool.empty();
        CreateCommand command = new CreateCommand(new Counter(0));

        //when
        command.act(creatableTaskPool, executableTaskPool);
        boolean actual = executableTaskPool.isEmpty();

        //then
        Assertions.assertThat(actual)
            .isTrue();
    }

}