package taskjob;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import taskjob.aggregator.Counter;

class CounterTest {

    @DisplayName("1씩 count 가 증가합니다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,5,100})
    void test1(int count){
        //given
        Counter counter = new Counter(0);

        //when
        for(int n = 0 ; n < count ; n++){
            counter.increase();
        }
        String actual = counter.getCountAsView();

        //then
        Assertions.assertThat(actual)
            .isEqualTo(Integer.toString(count));
    }
}