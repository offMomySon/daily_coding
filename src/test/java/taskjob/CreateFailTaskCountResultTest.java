package taskjob;

import java.text.MessageFormat;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import taskjob.aggregator.Counter;
import taskjob.result.CreateFailTaskCountResult;

class CreateFailTaskCountResultTest {

    private static final String VIEW_FORMAT = "TASK 생성 실패 : {0}";

    @DisplayName("생성 실패에 대해 count view 를 보여줍니다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,5,100,200})
    void test1(int n){
        //given
        Counter counter = new Counter(n);
        CreateFailTaskCountResult createFailTaskCountResult = CreateFailTaskCountResult.from(counter);

        String expect = MessageFormat.format(VIEW_FORMAT, n);

        //when
        String actual = createFailTaskCountResult.getResult();

        //then
        Assertions.assertThat(actual)
            .isEqualTo(expect);
    }

}