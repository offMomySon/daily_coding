package taskjob_2.result;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import lombok.NonNull;
import taskjob_2.aggregator.TaskCount;

/**
 * task 별 실행 실패 횟수를 출력하는 역할.
 */
public class ExecuteFailResult implements ResultPrinter {
    private final List<TaskCount> value;

    private ExecuteFailResult(@NonNull List<TaskCount> value) {
        this.value = value;
    }

    public static ExecuteFailResult from(@NonNull List<TaskCount> taskCounts){
        List<TaskCount> collect = taskCounts.stream()
            .sorted()
            .collect(Collectors.toUnmodifiableList());

        return new ExecuteFailResult(collect);
    }

    @Override
    public void print() {
        String result = MessageFormat.format("TASK 수행 실패한 태그: {0}", getFailTaskResult());
        System.out.println(result);
    }

    private String getFailTaskResult(){
        return value.stream()
            .map(ft-> MessageFormat.format("{0}({1})",ft.getCount(), ft.getTask().getTag()))
            .collect(Collectors.joining(" "));
    }
}
