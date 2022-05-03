package taskjob_1.v3.result;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.NonNull;
import taskjob_1.v3.aggregator.TaskCounter;
import taskjob_1.v3.domian.Task;

public class ExecuteFailResult implements Result{
    private static final String format = "TASK 수행 실패한 태그 : %s";

    private final TaskCounter taskCounter;

    public ExecuteFailResult(@NonNull TaskCounter taskCounter) {
        this.taskCounter = taskCounter;
    }

    @Override
    public void print() {
        String result = String.format(format,createExecuteFailResult());
        System.out.println(result);
    }

    private String createExecuteFailResult(){
        List<FailTask> failTasks = getFailTasks();

        return failTasks.stream()
            .sorted()
            .map(ft -> ft.getTask().getValue() + "(" + ft.getCount() + ")")
            .collect(Collectors.joining(" "));
    }

    private List<FailTask> getFailTasks(){
        Map<Task, Integer> countGroupByTask = taskCounter.getCountMapAsView();

        return countGroupByTask.keySet().stream()
            .map(t -> new FailTask(countGroupByTask.get(t), t))
            .collect(Collectors.toList());
    }


}
