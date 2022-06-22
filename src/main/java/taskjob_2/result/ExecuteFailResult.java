package taskjob_2.result;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.NonNull;
import org.apache.commons.lang3.compare.ComparableUtils;
import org.jetbrains.annotations.NotNull;
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
        List<TaskCount> newTaskCounts = new ArrayList<>(taskCounts);

        newTaskCounts.sort(new TaskCounterComparator());

        return new ExecuteFailResult(newTaskCounts);
    }

    @Override
    public void print() {
        String result = MessageFormat.format("TASK 수행 실패한 태그: {0}", getFailTaskResult());
        System.out.println(result);
    }

    private String getFailTaskResult(){
        return value.stream()
            .map(ft-> MessageFormat.format("{0}({1})",ft.getTask().getTagAsView(), ft.getCount()))
            .collect(Collectors.joining(" "));
    }

    private static class TaskCounterComparator implements Comparator<TaskCount>{
        @Override
        public int compare(TaskCount o1, TaskCount o2) {
            if(o1.getCount() == o2.getCount()){
                return o1.getTask().compareTo(o2.getTask());
            }

            return o2.getCount() - o1.getCount();
        }
    }
}
