package taskjob_1;

import taskjob_1.v2.aggregate.CreateFailCounter;
import taskjob_1.v2.aggregate.ExecuteFailCounter;
import taskjob_1.v2.command.CompositedCommand;
import taskjob_1.v2.command.CreateCommand;
import taskjob_1.v2.command.ExecuteCommand;
import taskjob_1.v2.domain.Task;
import taskjob_1.v2.pool.CreatedTaskPool;
import taskjob_1.v2.pool.UsableTaskPool;
import taskjob_1.v2.printer.CompositeResult;
import taskjob_1.v2.printer.CreateFailResult;
import taskjob_1.v2.printer.ExecuteFailResult;
import taskjob_1.v2.printer.UsableTagResult;

public class App {
    private static final String[] INPUT1 = new String[] {
        "create",
        "create",
        "create",
        "create",
        "create",
        "execute 2"
    };

    private static final String[] INPUT2 = new String[] {
        "create",
        "create",
        "create",
        "create",
        "create",
        "create",
        "create",
        "create",
        "create",
        "create"
    };

    private static final String[] INPUT3 = new String[] {
        "create",
        "create",
        "create",
        "create",
        "execute 11",
        "create",
        "create",
        "create",
        "create",
        "create",
        "create",
        "execute 2",
        "create",
        "execute 2",
        "execute 11",
        "execute 2",
        "execute 5",
        "execute 5",
        "execute 2",
        "execute 5",
        "execute 5"
    };

    public static void main(String[] args) {
        UsableTaskPool usableTaskPool = UsableTaskPool.of(Task.createSystemDefaultTasks());
        CreatedTaskPool createdTaskPool = new CreatedTaskPool();

        CreateFailCounter createFailCounter = new CreateFailCounter();
        ExecuteFailCounter executeFailCounter = new ExecuteFailCounter();

        UsableTagResult usableTagResult = new UsableTagResult(usableTaskPool);
        CreateFailResult createFailResult = new CreateFailResult(createFailCounter);
        ExecuteFailResult executeFailResult = new ExecuteFailResult(executeFailCounter);
        CompositeResult compositeResult = CompositeResult.of(usableTagResult, createFailResult, executeFailResult);

        CompositedCommand command = CompositedCommand.of(new CreateCommand(createFailCounter),
                                                    new ExecuteCommand(executeFailCounter));
        // TODO
        /**
         * for 문이 main 에 있지 않고 더 감추고 싶다..
         * for 문을 감추기 위한 객체를 생성한다고 가정했을때, 해당 객체의 역할이 너무 적을 것 같다.
         * 감추는게 맞는 걸까..?
         */
        for(String cmd : INPUT3){
            if(command.isNotExecutable(cmd)){
                continue;
            }
            command.execute(cmd, usableTaskPool, createdTaskPool);
        }

        String result = compositeResult.create();
        System.out.println(result);
    }
}
