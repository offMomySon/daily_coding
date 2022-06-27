package taskjob.aggregator;

import java.util.HashMap;
import java.util.Map;
import lombok.NonNull;
import taskjob.Task;

public class TaskCounter {
    private final Map<Task, Integer> groupByTaskCount;

    public TaskCounter() {
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
