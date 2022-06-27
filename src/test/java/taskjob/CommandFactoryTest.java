package taskjob;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class CommandFactoryTest {

    @DisplayName("입력한 cmd 가 올바르면 command 객체를 생성합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"create", "execute 1", "execute 2", "execute 100"})
    void test1(String sCmd){
        //given
        CommandFactory commandFactory = new CommandFactory();

        //when
        Throwable actual = Assertions.catchThrowable(() -> commandFactory.create(sCmd));

        //then
        Assertions.assertThat(actual)
            .isNull();
    }

    @DisplayName("입력한 cmd 의 길이가 올바르지 않으면, exeception 이 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"execute"})
    @NullSource
    @EmptySource
    void test2(String sCmd){
        //given
        CommandFactory commandFactory = new CommandFactory();

        //when
        Throwable actual = Assertions.catchThrowable(()-> commandFactory.create(sCmd));

        //then
        Assertions.assertThat(actual)
            .isNotNull();
    }
}