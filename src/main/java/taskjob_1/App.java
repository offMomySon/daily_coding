package taskjob_1;

import java.util.List;
import taskjob_1.v2.aggregate.CreateFailCounter;
import taskjob_1.v2.aggregate.ExecuteFailCounter;
import taskjob_1.v2.command.CompositedCommand;

import taskjob_1.v3.aggregator.Counter;
import taskjob_1.v3.aggregator.TaskCounter;
import taskjob_1.v3.command.Command;
import taskjob_1.v3.command.CreateCommand;
import taskjob_1.v3.command.ExecuteCommand;
import taskjob_1.v3.command.factory.CompositeCommandFactory;
import taskjob_1.v3.command.factory.CreateCommandFactory;
import taskjob_1.v3.command.factory.ExecuteCommandFactory;
import taskjob_1.v3.domian.Task;
import taskjob_1.v2.pool.CreatedTaskPool;
import taskjob_1.v2.pool.UsableTaskPool;
import taskjob_1.v3.pool.HashedTaskPool;
import taskjob_1.v3.pool.TaskPool;
import taskjob_1.v3.result.CompositeResult;
import taskjob_1.v3.result.CreateFailResult;
import taskjob_1.v3.result.ExecuteFailResult;
import taskjob_1.v3.result.UsableTagResult;

public class App {
    private static final String[] INPUT1 = new String[]{
        "create",
        "create",
        "create",
        "create",
        "create",
        "execute 2"
    };

    private static final String[] INPUT2 = new String[]{
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

    private static final String[] INPUT3 = new String[]{
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
        TaskPool usablePool = TaskPool.of(Task.createDefaultSystemTasks());
        HashedTaskPool actablePool = new HashedTaskPool();

        Counter createFailCounter = new Counter();
        TaskCounter executeFailCounter = new TaskCounter();

        CompositeCommandFactory commandFactory = new CompositeCommandFactory(List.of(new CreateCommandFactory(createFailCounter), new ExecuteCommandFactory(executeFailCounter)));

        for(String _cmd : INPUT2){
            Command command = commandFactory.create(_cmd);

            command.execute(usablePool, actablePool);
        }

        CompositeResult result = new CompositeResult(List.of(new UsableTagResult(usablePool),new CreateFailResult(createFailCounter),  new ExecuteFailResult(executeFailCounter)));
        result.print();
    }
}
