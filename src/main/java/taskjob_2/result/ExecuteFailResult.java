package taskjob_2.result;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.NonNull;
import taskjob_2.FailTask;
import taskjob_2.Task;

public class ExecuteFailResult implements ResultPrinter {
    private final List<FailTask> value;

    private ExecuteFailResult(@NonNull List<FailTask> value) {
        this.value = value;
    }

    public static ExecuteFailResult from(@NonNull Map<Task,Integer> taskCounters){
        List<FailTask> failTasks = taskCounters.entrySet().stream()
            .map(entry -> new FailTask(entry.getKey(), entry.getValue()))
            .sorted()
            .collect(Collectors.toUnmodifiableList());

        return new ExecuteFailResult(failTasks);
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
