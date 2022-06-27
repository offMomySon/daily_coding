package taskjob;

import java.text.MessageFormat;
import lombok.NonNull;

public class CreateTaskFailCountResult {
    private final String count;

    private CreateTaskFailCountResult(@NonNull String count) {
        this.count = count;
    }

    public static CreateTaskFailCountResult from(@NonNull Counter counter){
        return new CreateTaskFailCountResult(counter.getCountAsView());
    }

    public String getResult() {
        return MessageFormat.format("TASK 생성 실패 : {0}", count);
    }
}
