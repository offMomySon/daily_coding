package taskjob_1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExecuteFailCounter {
    private final Map<Task, Integer> pool = new HashMap<>();

    public void add(Task failTask) {
        if (pool.containsKey(failTask)) {
            pool.put(failTask, pool.get(failTask) + 1);
        }

        pool.put(failTask, 1);
    }

    public List<FailTask> getFailTasks() {
        return pool.keySet().stream().map(it -> new FailTask(it, pool.get(it))).collect(Collectors.toList());
    }
}
