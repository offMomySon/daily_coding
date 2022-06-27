package taskjob.result;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import taskjob.Task;
import taskjob.aggregator.TaskCounter;

public class ExecuteFailTaskResult implements TaskResult {
    private static final String RESULT_DELIMITER = " ";

    private final List<FailTaskCount> failTaskCounts;

    private ExecuteFailTaskResult(@NonNull List<FailTaskCount> failTaskCounts) {
        this.failTaskCounts = failTaskCounts;
    }

    public static ExecuteFailTaskResult from(@NonNull TaskCounter counter){
        List<FailTaskCount> failTaskCounts = counter.getTaskCountsAsView().entrySet().stream().map(
            entry -> new FailTaskCount(entry.getKey(), entry.getValue())).sorted().collect(
            Collectors.toUnmodifiableList());
        return new ExecuteFailTaskResult(failTaskCounts);
    }

    public String getResult(){
        return MessageFormat.format("TASK 수행 실패한 태그 : {0}", createExecuteFailResult() );
    }

    private String createExecuteFailResult(){
        return failTaskCounts.stream()
            .map(failTaskCount -> MessageFormat.format("{0} ({1})", failTaskCount.getTask().getAsView(), failTaskCount.getCount()))
            .collect(Collectors.joining(RESULT_DELIMITER));
    }

    @Getter
    private static class FailTaskCount implements Comparable<FailTaskCount> {
        private final Task task;
        private final int count;

        private FailTaskCount(Task task, int count) {
            this.task = task;
            this.count = count;
        }

        @Override
        public int compareTo(@NotNull FailTaskCount o) {
            if(o.count == count) {
                return task.compareTo(o.task);
            }

            return o.count - count;
        }
    }

}
