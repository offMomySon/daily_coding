package taskjob.pool;

import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import lombok.NonNull;
import taskjob.Task;

public class TaskPool {
    private final PriorityQueue<Task> pool;

    private TaskPool(PriorityQueue<Task> pool) {
        this.pool = pool;
    }

    public static TaskPool of(@NonNull List<Task> tasks){
        return new TaskPool(new PriorityQueue<>(tasks));
    }

    public boolean isEmpty(){
        return pool.isEmpty();
    }

    public boolean notEmpty(){
        return !isEmpty();
    }

    public void add(@NonNull Task task){
        pool.add(task);
    }

    public Optional<Task> pollMinimumTask(){
        return Optional.ofNullable(pool.poll());
    }

    public List<Task> getTasksAsView(){
        return pool.stream().collect(Collectors.toUnmodifiableList());
    }
}
