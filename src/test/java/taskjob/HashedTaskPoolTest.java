package taskjob;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import taskjob.pool.HashedTaskPool;

class HashedTaskPoolTest {

    @DisplayName("pool 내에 요청한 tag 번호의 Task 가 있으면 동일한 tag 번호의 Task 를 받습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "100,200,300,400,500"})
    void test1(String sNums){
        //given
        List<Task> tasks = Arrays.stream(sNums.split(",")).map(Task::from).collect(Collectors.toList());
        HashedTaskPool pool = HashedTaskPool.of(tasks);

        Task expect = tasks.stream().findAny().orElseThrow();

        //when
        Task actual = pool.poll(expect).orElseThrow();

        //then
        Assertions.assertThat(actual)
            .isEqualTo(expect);
    }

    @DisplayName("pool 내에 요청한 tag 번호의 Task 가 없으면, 비어있는 optional 을 받습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "100,200,300,400,500"})
    void test2(String sNums){
        //given
        int maxNum = Arrays.stream(sNums.split(",")).mapToInt(Integer::parseInt).max().getAsInt();
        Task notExistTask = Task.from(Integer.toString(maxNum+1));

        HashedTaskPool pool = HashedTaskPool.of(Arrays.stream(sNums.split(",")).map(Task::from).collect(Collectors.toList()));

        //when
        boolean actual = pool.poll(notExistTask).isEmpty();

        //then
        Assertions.assertThat(actual)
            .isTrue();
    }

    @DisplayName("pool 이 비어있는 상태이면 true 를 반환합니다.")
    @Test
    void test3() {
        //given
        HashedTaskPool hashedTaskPool = HashedTaskPool.empty();

        //when
        boolean actual = hashedTaskPool.isEmpty();

        //then
        Assertions.assertThat(actual)
            .isTrue();
    }

    @DisplayName("pool 에 존재하지 않는 task 라면 true 를 반환합니다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2", "2,3", "4,5"})
    void test4(String includeTag, String notIncludeTag) {
        //given
        Task includeTask = Task.from(includeTag);
        Task notIncludeTask = Task.from(notIncludeTag);

        HashedTaskPool hashedTaskPool = HashedTaskPool.empty();

        hashedTaskPool.add(includeTask);

        //when
        boolean actual = hashedTaskPool.notContain(notIncludeTask);

        //then
        Assertions.assertThat(actual)
            .isTrue();
    }

}