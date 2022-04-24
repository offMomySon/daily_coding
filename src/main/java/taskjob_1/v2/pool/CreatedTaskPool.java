package taskjob_1.v2.pool;

import java.util.HashSet;
import java.util.Set;
import taskjob_1.v2.domain.Task;

/**
 * 생성된 task 를 빠르게 O(1 or logN) 에 찾기 위해서 HashSet 사용.
 *
 * 시간 복잡도를 생각했을때,
 * TreeSet 은 O(logN) 시간 소요되기 때문에, HashSet 이 더 좋지 않나?
 *
 * 용도의 측면에서,
 * CreateTaskPool, LoadedTaskPool 둘다 pool 을 관리하지만 용도가 다르기 때문에 다른 class 로 구현.
 *
 * CreateTaskPool 은 '특정 value' 를 가진 객체를 빠르게 찾기 위한 용도.
 * LoadedTaskPool 은 '가장 작은 value' 를 가진 객체를 순차적 으로 찾기 위한 용도.
 */
public class CreatedTaskPool {
    private final Set<Task> pool = new HashSet<>();

    public boolean has(Task task){
        return pool.contains(task);
    }

    public boolean notHas(Task task){
        return !has(task);
    }

    public void remove(Task task){
        pool.remove(task);
    }

    public void add(Task task){
        pool.add(task);
    }
}
