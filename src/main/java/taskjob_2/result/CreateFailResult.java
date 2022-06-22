package taskjob_2.result;

import java.text.MessageFormat;
import lombok.NonNull;
import taskjob_2.aggregator.Counter;

/**
 * 생성 실패 횟수를 출력하는 역할.
 */
public class CreateFailResult implements ResultPrinter {
    private final String count;

    private CreateFailResult(@NonNull String count) {
        this.count = count;
    }

    public static CreateFailResult from(@NonNull Counter counter){
        String count = counter.getValueAsView();

        return new CreateFailResult(count);
    }

    @Override
    public void print() {
        String result = MessageFormat.format("TASK 생성 실패: {0}", count);
        System.out.println(result);
    }
}
