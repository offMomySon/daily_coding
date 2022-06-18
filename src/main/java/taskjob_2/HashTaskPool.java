package taskjob_2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.NonNull;

/**
 * task 를 관리하는 역할.
 */
public class HashTaskPool {
    private final Set<Task> pool = new HashSet<>();

    public void add(Task ...task){
        pool.addAll(List.of(task));
    }

    public boolean isExist(@NonNull Task task){
        return pool.contains(task);
    }

    public void remove(@NonNull Task task){
        pool.remove(task);
    }
}
