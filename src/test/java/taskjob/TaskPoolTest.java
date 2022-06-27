package taskjob;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TaskPoolTest {

    @DisplayName("pool 에서 가장 작은 task 가져옵니다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "100,200,300"})
    void test1(String tags){
        //given
        List<Task> tasks = Arrays.stream(tags.split(",")).map(Task::from).collect(Collectors.toList());
        TaskPool taskPool = TaskPool.of(tasks);

        String sMinNum = String.valueOf(Arrays.stream(tags.split(",")).mapToInt(Integer::parseInt).min().orElseThrow());
        Task expect = Task.from(sMinNum);

        //when
        Task actual = taskPool.pollMinimumTask().orElseThrow();

        //then
        Assertions.assertThat(actual)
            .isEqualTo(expect);
    }

    @DisplayName("pool 에 task 가 존재하지 않으면, 비어있는 값을 가져옵니다.")
    @Test
    void test2(){
        //given
        TaskPool taskPool = TaskPool.of(Collections.emptyList());

        //when
        boolean actual = taskPool.pollMinimumTask().isEmpty();

        //then
        Assertions.assertThat(actual)
            .isTrue();
    }

    @DisplayName("pool 에 task 가 존재하지 않으면, true 를 반환합니다.")
    @Test
    void test3() {
        //given
        TaskPool taskPool = TaskPool.of(Collections.emptyList());

        //when
        boolean actual = taskPool.isEmpty();

        //then
        Assertions.assertThat(actual)
            .isTrue();
    }
}