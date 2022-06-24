package taskjob_2.pool;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import taskjob_2.Task;

public class HashedTaskPool {
    private final Set<Task> pool = new HashSet<>();

    public void add(Task ...tasks){
        pool.addAll(List.of(tasks));
    }

    public Optional<Task> getExecutableTask(Task task){
        if(notContains(task)){
            return Optional.empty();
        }

        pool.remove(task);

        return Optional.of(task);
    }

    private boolean contains(Task task){
        return pool.contains(task);
    }

    public boolean notContains(Task task){
        return !contains(task);
    }
}
