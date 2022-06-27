package taskjob.result;

import java.util.List;
import java.util.stream.Collectors;
import lombok.NonNull;

public class CompositedTaskResult implements TaskResult{
    private final List<TaskResult> taskResults;

    public CompositedTaskResult(@NonNull List<TaskResult> taskResults) {
        this.taskResults = taskResults;
    }

    @Override
    public String getResult() {
        return taskResults.stream()
            .map(TaskResult::getResult)
            .collect(Collectors.joining("\n"));
    }
}
