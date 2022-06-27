package taskjob.result;

import java.text.MessageFormat;
import lombok.NonNull;
import taskjob.aggregator.Counter;

public class CreateFailTaskCountResult {
    private final String count;

    private CreateFailTaskCountResult(@NonNull String count) {
        this.count = count;
    }

    public static CreateFailTaskCountResult from(@NonNull Counter counter){
        return new CreateFailTaskCountResult(counter.getCountAsView());
    }

    public String getResult() {
        return MessageFormat.format("TASK 생성 실패 : {0}", count);
    }
}
