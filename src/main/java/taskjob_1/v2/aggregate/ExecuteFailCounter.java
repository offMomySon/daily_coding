package taskjob_1.v2.aggregate;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import taskjob_1.v2.domain.Task;

/**
 * 역할
 * task 의 실패 횟수를 집계하기 위한 counter 클래스
 */
public class ExecuteFailCounter {
    // TODO
    /**
     * 1. 메서드 명.
     * 이름이 짓기가 애매하다.
     * ExecuteFailCounter 의 모든 역할 을 수행하는 instance validable 이다.
     *
     * 2. 역할.
     * task 의 fail count 를 세기위한 자료구조.
     */

    // TODO
    /**
     * counter 자료형 비교
     * Map<Task, FailTask> counter 가 좋은가?
     * Map<Task, Integer> 가 좋을가?
     */
    /**
     * Map<Task, FailTask> 로 구현.
     */
    private final Map<Task, FailTask> counter1 = new HashMap<>();

    public void increase1(Task task){
        if(counter1.containsKey(task)){
            FailTask failTask = counter1.get(task);

            counter1.put(task, failTask.increaseCount());
            return;
        }
        counter1.put(task, new FailTask(task, 1));
    }

    public Collection<FailTask> getFailTask1(){
        return counter1.values();
    }

    // Todo
    /**
     * Map<Task, Integer> 로 구현.
     */
    private final Map<Task, Integer> counter2 = new HashMap<>();

    public void increase2(Task task){
        if(counter2.containsKey(task)){
            Integer count = counter2.get(task);

            counter2.put(task, count +1);
            return;
        }

        counter2.put(task, 1);
    }

    public Collection<FailTask> getFailTask2(){
        List<FailTask> failTasks = new LinkedList<>();

        for (Task task : counter2.keySet()){
            Integer count = counter2.get(task);

            failTasks.add(new FailTask(task, count));
        }

        return failTasks;
    }
}
