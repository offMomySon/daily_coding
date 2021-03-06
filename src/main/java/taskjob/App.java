package taskjob;


import java.util.List;
import taskjob.aggregator.Counter;
import taskjob.aggregator.TaskCounter;
import taskjob.command.Command;
import taskjob.command.CommandFactory;
import taskjob.pool.HashedTaskPool;
import taskjob.pool.TaskPool;
import taskjob.result.CompositedTaskResult;
import taskjob.result.CreatableTaskResult;
import taskjob.result.CreateFailTaskCountResult;
import taskjob.result.ExecuteFailTaskResult;

public class App {
    private static final String[] TEST_CMD_SHEET_1= {
        "create",
        "create",
        "create",
        "create",
        "create",
        "execute 2"
    };

    private static final String[] TEST_CMD_SHEET_2= {
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

    private static final String[] TEST_CMD_SHEET_3= {
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
        TaskPool taskPool = TaskPool.of(Task.systemDefaultTasks());
        HashedTaskPool hashedTaskPool = HashedTaskPool.empty();

        Counter createFailCounter = new Counter(0);
        TaskCounter executeFailCounter = new TaskCounter();

        CommandFactory commandFactory = new CommandFactory(createFailCounter, executeFailCounter);

        for(String sCmd : TEST_CMD_SHEET_1){
            Command command = commandFactory.create(sCmd);
            command.act(taskPool, hashedTaskPool);
        }

        CompositedTaskResult taskResult = new CompositedTaskResult(List.of(
            CreatableTaskResult.from(taskPool),
            CreateFailTaskCountResult.from(createFailCounter),
            ExecuteFailTaskResult.from(executeFailCounter)
        ));
        System.out.println(taskResult.getResult());
    }
}
