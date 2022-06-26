package taskjob;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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

        Task expect = Task.from(String.valueOf(Arrays.stream(tags.split(",")).mapToInt(Integer::parseInt).min()));

        //when
        Task actual = taskPool.pollMinimumTask().orElseThrow();

        //then
        Assertions.assertThat(actual)
            .isEqualTo(expect);
    }

}