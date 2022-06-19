package taskjob_2.result;

import java.text.MessageFormat;
import lombok.NonNull;
import taskjob_2.aggregator.Counter;

/**
 * 생성 실패 횟수를 출력하는 역할.
 */
public class CreateFailResult implements ResultPrinter {
    private final int count;

    public CreateFailResult(int count) {
        this.count = count;
    }

    @Override
    public void print() {
        String result = MessageFormat.format("TASK 생성 실패: {0}", count);
        System.out.println(result);
    }
}
