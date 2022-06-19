package taskjob_2.pool;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.NonNull;
import taskjob_2.Task;

/**
 * task 를 관리하는 역할.
 */
public class HashTaskPool {
    private final Set<Task> pool = new HashSet<>();

    public void push(Task ...task){
        pool.addAll(List.of(task));
    }

    private boolean isExist(@NonNull Task task){
        return pool.contains(task);
    }

    public boolean notExist(@NonNull Task task){
        return !isExist(task);
    }
    public Task get(@NonNull Task task){
        if(!pool.remove(task)){
            throw new RuntimeException("Not exist task");
        }

        return task;
    }
}
