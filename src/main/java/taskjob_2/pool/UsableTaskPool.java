package taskjob_2.pool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.NonNull;
import taskjob_2.Task;

public class UsableTaskPool {
    private final PriorityQueue<Task> usablePool;

    public UsableTaskPool(@NonNull List<Task> tasks) {
        usablePool = new PriorityQueue<>(tasks);
    }

    public void add(Task ...tasks){
        usablePool.addAll(List.of(tasks));
    }

    public boolean notLeft(){
        return usablePool.isEmpty();
    }

    public Task pollMinimumTask(){
        return usablePool.poll();
    }

    public List<Task> getTasks(){
        return usablePool.stream().collect(Collectors.toUnmodifiableList());
    }
}
