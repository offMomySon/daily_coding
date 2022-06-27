package taskjob.aggregator;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.NonNull;
import taskjob.Task;

public class TaskCount {
    private final Map<Task, Integer> groupByTaskCount;

    public TaskCount() {
        this.groupByTaskCount = new HashMap<>();
    }

    public void add(@NonNull Task task){
        if(groupByTaskCount.containsKey(task)){
            groupByTaskCount.put(task, groupByTaskCount.get(task) + 1);
        }

        groupByTaskCount.put(task, 1);
    }

    public Map<Task, Integer> getTaskCountsAsView() {
        return new HashMap<>(groupByTaskCount);
    }
}
