package taskjob_1.v2;

import org.junit.jupiter.api.Test;
import taskjob_1.v2.domain.Task;
import taskjob_1.v2.pool.UsableTaskPool;

class TaskTest {

    @Test
    void test1(){
        UsableTaskPool usableTaskPool = UsableTaskPool.of(Task.createSystemDefaultTasks());

        while(usableTaskPool.hasNext()){
            Task peek = usableTaskPool.poll();
            System.out.println(peek);
        }
    }
}