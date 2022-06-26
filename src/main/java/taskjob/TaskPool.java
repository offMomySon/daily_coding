package taskjob;

import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import lombok.NonNull;

public class TaskPool {
    private final PriorityQueue<Task> pool;

    private TaskPool(PriorityQueue<Task> pool) {
        this.pool = pool;
    }

    public static TaskPool of(@NonNull List<Task> tasks){
        return new TaskPool(new PriorityQueue<>(tasks));
    }

    public void add(@NonNull Task task){
        pool.add(task);
    }

    public Optional<Task> pollMinimumTask(){
        return Optional.ofNullable(pool.poll());
    }
}
