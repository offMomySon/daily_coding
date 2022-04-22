package taskjob_1;

import java.util.List;
import java.util.PriorityQueue;

public class TaskPool {
    private final PriorityQueue<Task> pool;

    private TaskPool(PriorityQueue<Task> pool) {
        this.pool = pool;
    }

    public static TaskPool from(List<Task> tasks) {
        return new TaskPool(new PriorityQueue<>(tasks));
    }

    public Task peek() {
        return pool.peek();
    }

    public Task poll() {
        return pool.poll();
    }

    public boolean isEmpty() {
        return pool.isEmpty();
    }
}
