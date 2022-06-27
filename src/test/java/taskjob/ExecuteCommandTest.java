package taskjob;

import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExecuteCommandTest {

    @DisplayName("executable pool 에서 task 가 제거되고, creatable pool 에 task 가 추가 됩니다.")
    @Test
    void test1(){
        //given
        Task requestTask = Task.from("1");
        TaskPool creatableTaskPool = TaskPool.of(Collections.emptyList());
        HashedTaskPool executableTaskPool = HashedTaskPool.of(List.of(requestTask));
        ExecuteCommand command = new ExecuteCommand(requestTask);

        //when
        command.act(creatableTaskPool, executableTaskPool);
        boolean actual = creatableTaskPool.notEmpty();

        //then
        Assertions.assertThat(actual)
            .isTrue();
    }

    @DisplayName("executable pool 이 비어있으면, creatable pool 에 task 가 추가 되지 않습니다.")
    @Test
    void test2(){
        //given
        Task requestTask = Task.from("1");
        TaskPool creatableTaskPool = TaskPool.of(Collections.emptyList());
        HashedTaskPool executableTaskPool = HashedTaskPool.empty();
        ExecuteCommand command = new ExecuteCommand(requestTask);

        //when
        command.act(creatableTaskPool, executableTaskPool);
        boolean actual = creatableTaskPool.isEmpty();

        //then
        Assertions.assertThat(actual)
            .isTrue();
    }

}