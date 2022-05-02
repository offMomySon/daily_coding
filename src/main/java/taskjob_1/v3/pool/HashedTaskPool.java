package taskjob_1.v3.pool;

import java.util.HashSet;
import java.util.Set;
import taskjob_1.v3.domian.Task;

/**
 * 실행가능한 task 들을 빠르게 찾기 위한 역할.
 */
public class HashedTaskPool {
    private final Set<Task> pool = new HashSet<>();

    public boolean contain(Task task){
        return pool.contains(task);
    }

    public boolean notContain(Task task){
        return !contain(task);
    }

    public void remove(Task task){
        pool.remove(task);
    }

    public void add(Task task){
        pool.add(task);
    }

}
