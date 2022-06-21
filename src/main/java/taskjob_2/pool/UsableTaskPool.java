package taskjob_2.pool;

import java.util.List;
import java.util.PriorityQueue;
import taskjob_2.Task;

public class UsableTaskPool {
    private final PriorityQueue<Task> usablePool = new PriorityQueue<>();

    public void add(Task ...tasks){
        usablePool.addAll(List.of(tasks));
    }

    public boolean notLeft(){
        return usablePool.isEmpty();
    }


    public Task getMinimumUsableTask(){
        return usablePool.poll();
    }
}
