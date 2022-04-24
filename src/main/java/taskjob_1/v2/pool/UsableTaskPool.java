package taskjob_1.v2.pool;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import lombok.NonNull;
import taskjob_1.v2.domain.Task;


/**
 * system 에 사용가능한 task 들을 관리하기 위한 pool.
 * peek , push 때 자동으로 정렬하기 위해 priority queue 를 사용한다.
 *
 * 하는 역할이 적은데? -> 그냥 pool 을 다룬다.
 * 굳이 pool class 로 만들어야할까? -> 자료구조로 만 사용하면 안되나?
 *
 * 사용처를 생각해봤을때,
 * 1. system queue 의 생성이 강제된다. fm 을 통해서.
 * 2. task 실행을 위해, 다른 객체에서 task 를 가져가는 역할.
 *
 * 1 번 때문에 사용.
 */
public class UsableTaskPool {
    private final PriorityQueue<Task> pool;

    private UsableTaskPool(@NonNull PriorityQueue<Task> pool) {
        this.pool = pool;
    }

    /**
     * 생성을 of 로 강제했기 때문에, system 에서 만들어진 tasks 를 통해서, 등록이 완료된 pool 을 만든다.
     * 라는 객체의 역할 이 생겼다.
     */
    public static UsableTaskPool of(List<Task> tasks){
        return new UsableTaskPool(new PriorityQueue<>(tasks));
    }

    public Task poll(){
        return pool.poll();
    }

    public Task poo(){
        return pool.peek();
    }

    public void add(Task task){
        pool.add(task);
    }

    /**
     * 하나의 Task 씩 가져오기 때문에 hasNext 가 더 맞아 보임.
     */
    public boolean hasNext() {
        return !pool.isEmpty();
    }

    public boolean notHasNext() {
        return !hasNext();
    }

    public List<Task> getTasks(){
        return pool.stream().collect(Collectors.toList());
    }
}
