package taskjob;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

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
        Task actual = pool.pollIfExist(expect).orElseThrow();

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
        boolean actual = pool.pollIfExist(notExistTask).isEmpty();

        //then
        Assertions.assertThat(actual)
            .isTrue();
    }
}