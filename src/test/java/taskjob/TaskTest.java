package taskjob;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TaskTest {

    @DisplayName("숫자로 변환가능한 string 으로 생성 될 수 있습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4","100"})
    void test1(String sNum){
        //given
        //when
        Throwable actual = Assertions.catchThrowable(() -> Task.from(sNum));

        //then
        Assertions.assertThat(actual).isNull();
    }

    @DisplayName("숫자로 변환 할 수 없는 String 은 Exception 이 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"a","b", "c", "d", "!"})
    void test2(String notNum){
        //given
        //when
        Throwable actual = Assertions.catchThrowable(()-> Task.from(notNum));

        //then
        Assertions.assertThat(actual).isNotNull();
    }

}