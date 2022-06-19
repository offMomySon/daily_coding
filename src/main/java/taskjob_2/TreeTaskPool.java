package taskjob_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import lombok.NonNull;

/**
 * Task 를 관리하는 역할.
 */
public class TreeTaskPool {
    private final TreeSet<Task> pool;

    private TreeTaskPool(@NonNull TreeSet<Task> pool) {
        this.pool = pool;
    }

    public static TreeTaskPool of(List<Task> tasks){
        TreeSet<Task> pool = new TreeSet<>(tasks);

        return new TreeTaskPool(pool);
    }

    private boolean isLeft(){
        return !pool.isEmpty();
    }
    public boolean notLeft(){
        return !isLeft();
    }

    public void add(Task ... tasks){
        pool.addAll(Arrays.asList(tasks));
    }

    public Task pull(){
        return pool.pollFirst();
    }

    public List<Task> getTasksAsView(){
        return new ArrayList<>(pool);
    }
}
