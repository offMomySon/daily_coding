package taskjob_1.v3.pool;

import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import lombok.NonNull;
import taskjob_1.v3.domian.Task;

/**
 * task 들을 담아두고 가장 작은 task 부터 뽑는 역할.
 */
public class TaskPool {
    private final PriorityQueue<Task> pool;

    private TaskPool(PriorityQueue<Task> pool) {
        this.pool = validate(pool);
    }

    private PriorityQueue<Task> validate(PriorityQueue<Task> pool){
        if(Objects.isNull(pool)){
            throw new RuntimeException("pool 이 null 입니다.");
        }

        PriorityQueue<Task> newPriorityQueue = new PriorityQueue<>(pool.stream().filter(Objects::nonNull).collect(Collectors.toList()));

        if(newPriorityQueue.isEmpty()){
            throw new RuntimeException("pool size 가 null 입니다.");
        }

        return newPriorityQueue;
    }

    public static TaskPool of(@NonNull List<Task> tasks){
        PriorityQueue<Task> pool = new PriorityQueue<>();
        pool.addAll(tasks);

        return new TaskPool(pool);
    }


    public Task poll() {

        return pool.poll();
    }

    public Task peek() {
        return pool.peek();
    }

    public boolean isEmpty(){
        return pool.isEmpty();
    }

    public void add(Task task){
        pool.add(task);
    }

    public PriorityQueue<Task> getPoolAsView(){
        return new PriorityQueue<>(pool);
    }
}
