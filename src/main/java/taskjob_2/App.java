package taskjob_2;


import java.util.List;
import java.util.Map;
import taskjob_1.v3.command.Command;
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
        TreeTaskPool usablePool = TreeTaskPool.of(Task.defaultSystemTasks());
        HashTaskPool executePool = new HashTaskPool();

        Counter createFailCounter = new Counter();
        TaskCounter executeFailCounter = new TaskCounter();

        for(String sCmd : TEST_CMD_SHEET_3){
            String[] splitCmd = sCmd.split(" ");

            Cmd cmd = Cmd.find(splitCmd[0]).orElseThrow(() -> new RuntimeException("일치하는 cmd 가 없습니다."));

            if(cmd == Cmd.CREATE){
                if(usablePool.notExist()){
                    createFailCounter.increase();
                    continue;
                }
                Task task = usablePool.pull();
                executePool.add(task);
                continue;
            }

            if( cmd == Cmd.EXECUTE){
                Task task = Task.of(splitCmd[1]);

                if(executePool.notExist(task)){
                    executeFailCounter.increase(task);
                    continue;
                }

                executePool.remove(task);
                usablePool.add(task);
                continue;
            }
        }

        CompositeResult resultPrinter = new CompositeResult(List.of(
            new UsableTagResult(usablePool.getTasksAsView()),
            new CreateFailResult(createFailCounter),
            ExecuteFailResult.from(executeFailCounter.getTaskCountAsView())));

        resultPrinter.print();
    }
}
