package taskjob;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import lombok.NonNull;

public class HashedTaskPool {
    private final Set<Task> pool;

    private HashedTaskPool(@NonNull Collection<Task> pool) {
        this.pool = new HashSet<>(pool);
    }

    public static HashedTaskPool of(@NonNull Collection<Task> tasks){
        return new HashedTaskPool(tasks);
    }

    public static HashedTaskPool empty(){
        return new HashedTaskPool(Collections.EMPTY_SET);
    }

    public void add(@NonNull Task task){
        pool.add(task);
    }

    private boolean contain(@NonNull Task task){
        return pool.contains(task);
    }

    public boolean notContain(@NonNull Task task){
        return !contain(task);
    }

    public boolean isEmpty(){
        return pool.isEmpty();
    }

    public boolean notEmpty(){
        return !isEmpty();
    }

    public Optional<Task> poll(@NonNull Task task){
        if(!pool.contains(task)){
            return Optional.empty();
        }

        pool.remove(task);
        return Optional.of(task);
    }
}
