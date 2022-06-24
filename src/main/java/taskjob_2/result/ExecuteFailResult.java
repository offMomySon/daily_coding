package taskjob_2.result;

import java.text.MessageFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.NonNull;
import taskjob_2.aggregator.TaskCount;
import taskjob_2.aggregator.TaskCounter;

/**
 * task 별 실행 실패 횟수를 출력하는 역할.
 */
public class ExecuteFailResult implements ResultPrinter {
    private final List<TaskCount> taskCounts;

    private ExecuteFailResult(@NonNull List<TaskCount> taskCounts) {
        List<TaskCount> newTaskCounts = taskCounts.stream().collect(Collectors.toUnmodifiableList());

        newTaskCounts.sort(new TaskCounterComparator());

        this.taskCounts = newTaskCounts;
    }

    public static ExecuteFailResult from(@NonNull TaskCounter executeFailCounter){
        return new ExecuteFailResult(executeFailCounter.getTaskCounts());
    }

    @Override
    public void print() {
        String result = MessageFormat.format("TASK 수행 실패한 태그: {0}", getFailTaskResult());
        System.out.println(result);
    }

    private String getFailTaskResult(){
        return taskCounts.stream()
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
