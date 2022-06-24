package taskjob_2;


import java.util.List;
import taskjob_2.aggregator.Counter;
import taskjob_2.aggregator.TaskCounter;
import taskjob_2.command.Command;
import taskjob_2.command.CommandFactory;
import taskjob_2.pool.HashedTaskPool;
import taskjob_2.pool.TaskPool;
import taskjob_2.result.CompositeResult;
import taskjob_2.result.CreateFailResult;
import taskjob_2.result.ExecuteFailResult;
import taskjob_2.result.UsableTagResult;

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
        TaskPool taskPool = new TaskPool(Task.defaultSystemTasks());
        HashedTaskPool hashedTaskPool = new HashedTaskPool();

        Counter createFailCounter = new Counter();
        TaskCounter executeFailCounter = new TaskCounter();

        CommandFactory commandFactory = new CommandFactory(createFailCounter, executeFailCounter);

        for(String sCmd : TEST_CMD_SHEET_1){
            Command command = commandFactory.create(sCmd);
            command.execute(taskPool, hashedTaskPool);
        }

        CompositeResult resultPrinter = new CompositeResult(List.of(
            UsableTagResult.from(taskPool),
            CreateFailResult.from(createFailCounter),
            ExecuteFailResult.from(executeFailCounter))
        );

        resultPrinter.print();
    }
}
