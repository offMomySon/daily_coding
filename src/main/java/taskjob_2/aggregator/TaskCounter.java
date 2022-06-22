package taskjob_2.aggregator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import taskjob_2.Task;

/**
 * task 마다의 횟수를 세는 역할.
 */
public class TaskCounter {
    private final Map<Task, Integer> value = new HashMap<>();

    public void increase(Task task){
        if(value.containsKey(task)){
            value.put(task, value.get(task) + 1);
            return;
        }

        value.put(task, 1);
    }

    public List<TaskCount> getTaskCounts(){
        return value.entrySet().stream()
            .map(entry -> new TaskCount(entry.getKey(), entry.getValue()))
            .collect(Collectors.toUnmodifiableList());
    }
}
