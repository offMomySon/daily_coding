package taskjob_1.v3.aggregator;

import java.util.HashMap;
import java.util.Map;
import lombok.NonNull;
import taskjob_1.v3.domian.Task;

public class TaskCounter {
    private final Map<Task, Integer> countGroupByTask = new HashMap<Task, Integer>();

    public void increase(@NonNull Task task){
        if(countGroupByTask.containsKey(task)){
            countGroupByTask.put(task, countGroupByTask.get(task) +1);
            return;
        }

        countGroupByTask.put(task, 1);
    }

    public Map<Task, Integer> getCountMapAsView(){
        return new HashMap<>(countGroupByTask);
    }
}
