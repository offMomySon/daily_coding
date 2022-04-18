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

    private static final Task task = new Task();

    private static final CreateFailCounter createFailCount = new CreateFailCounter();
    private static final ExecuteFailLogger executeFailLogger = new ExecuteFailLogger();

    private static final ResultMessage resultMessage = new ResultMessage();

    private static final Tag tag = new Tag();

    private static final TaskCreator taskCreator = new TaskCreator(createFailCount, tag);
    private static final TaskExecutor taskExecutor = new TaskExecutor(executeFailLogger, tag);

    private static final Executor executor = new Executor(executeFailLogger, createFailCount, taskCreator, taskExecutor);

    public static void main(String[] args) {
        for (int i = 0; i < INPUT3.length; i++) {
            Input input = Input.from(INPUT3[i]);

            executor.execute(input);
        }

        resultMessage.printUsableTag(task.getTag().getUsableTags());
        resultMessage.printCreateFail(createFailCount.getCount());
        resultMessage.printExecuteFails(executeFailLogger.getExecuteFails());
    }
}
