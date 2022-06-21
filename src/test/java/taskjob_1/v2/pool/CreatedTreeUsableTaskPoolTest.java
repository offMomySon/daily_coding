package taskjob_1.v2.pool;

import org.junit.jupiter.api.Test;
import taskjob_1.v2.domain.Task;
import static org.junit.jupiter.api.Assertions.*;

class CreatedTreeUsableTaskPoolTest {

    @Test
    void test1(){
        Task task = new Task("ab");
        CreatedTaskPool createdTaskPool = new CreatedTaskPool();

        createdTaskPool.add(task);

        boolean has = createdTaskPool.has(task);
        System.out.println(has);

        createdTaskPool.remove(task);
        boolean has1 = createdTaskPool.has(task);
        System.out.println(has1);

    }
}