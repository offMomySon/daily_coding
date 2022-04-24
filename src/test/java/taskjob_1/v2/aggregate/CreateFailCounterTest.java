package taskjob_1.v2.aggregate;

import org.junit.jupiter.api.Test;
import taskjob_1.v2.domain.Task;
import taskjob_1.v2.pool.UsableTaskPool;

class CreateFailCounterTest {

    @Test
    void test1(){
        UsableTaskPool usableTaskPool = UsableTaskPool.of(Task.createSystemDefaultTasks());
        CreateFailCounter createFailCounter = new CreateFailCounter();

        for (int i = 0; i < 10; i++) {

            if(usableTaskPool.hasNext()){
                usableTaskPool.poll();
                continue;
            }

            createFailCounter.increase();
        }

        System.out.println(createFailCounter.getCount());
    }
}