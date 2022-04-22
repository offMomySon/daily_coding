package taskjob_1;

import java.util.HashSet;
import java.util.Set;

public class ActivePool {
    private final Set<Task> pool = new HashSet<>();

    public void add(Task task) {
        pool.add(task);
    }

    public void remove(Task task) {
        pool.remove(task);
    }

    public boolean contain(Task task) {
        return pool.contains(task);
    }
}
