package taskjob;


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

        CommandFactory commandFactory = new CommandFactory(createFailCounter);

        for(String sCmd : TEST_CMD_SHEET_1){
            Command command = commandFactory.create(sCmd);
            command.act(taskPool, hashedTaskPool);
        }

        CreateTaskFailCountResult createTaskFailCountResult = CreateTaskFailCountResult.from(createFailCounter);
        System.out.println(createTaskFailCountResult.getResult());
    }
}
