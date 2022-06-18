package taskjob_2;

import java.util.HashMap;
import java.util.Map;

/**
 * task 마다의 횟수를 관리하는 역할.
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

    public Map<Task, Integer> getTaskCountAsView(){
        return new HashMap<>(value);
    }
}
