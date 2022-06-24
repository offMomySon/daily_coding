package taskjob_2.pool;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import lombok.NonNull;
import taskjob_2.Task;

public class TaskPool {
    private final PriorityQueue<Task> usablePool;

    public TaskPool(@NonNull List<Task> tasks) {
        usablePool = new PriorityQueue<>(tasks);
    }

    public void addUsableTask(Task ...tasks){
        usablePool.addAll(List.of(tasks));
    }

    public boolean notLeft(){
        return usablePool.isEmpty();
    }

    public Task pollMinimumUsableTask(){
        return usablePool.poll();
    }

    public List<Task> getTasks(){
        return usablePool.stream().collect(Collectors.toUnmodifiableList());
    }
}
