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

    private static final CreateFailCounter createFailCount = new CreateFailCounter();
    private static final ExecuteFailLogger executeFailLogger = new ExecuteFailLogger();

    private static final Tag tag = new Tag();

    private static final TaskCreator taskCreator = new TaskCreator(createFailCount, tag);
    private static final TaskExecutor taskExecutor = new TaskExecutor(executeFailLogger, tag);

    private static final Executor executor = new Executor(taskCreator, taskExecutor);

    public static void main(String[] args) {
        executor.execute(INPUT3);

        ResultMessage resultMessage = new ResultMessage();
        resultMessage.printUsableTag(tag.getUsableTags());
        resultMessage.printCreateFail(createFailCount.getCount());
        resultMessage.printExecuteFails(executeFailLogger.getExecuteFails());
    }
}
