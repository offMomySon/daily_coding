package taskjob;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import taskjob.aggregator.TaskCount;

class TaskCountTest {

    @DisplayName("입력 받은 task 횟수만큼 count 가 증가합니다.")
    @ParameterizedTest
    @CsvSource(value = {"1", "2,2", "3,3,3"})
    void test1(String sTags){
        //given
        List<Task> tasks = Arrays.stream(sTags.split(",")).map(Task::from).collect(Collectors.toUnmodifiableList());
        Map<Task, Integer> expect = Map.of(tasks.get(0), tasks.size());

        TaskCount taskCount = new TaskCount();
        tasks.forEach(taskCount::add);

        //when
        Map<Task, Integer> actual = taskCount.getTaskCountsAsView();

        //then
        Assertions.assertThat(actual)
            .isEqualTo(expect);
    }
}