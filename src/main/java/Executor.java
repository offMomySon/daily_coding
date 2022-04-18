public class Executor {
    private final ExecuteFailLogger executeFailLogger;
    private final CreateFailCounter createFailCounter;
    private final TaskCreator taskCreator;
    private final TaskExecutor taskExecutor;

    public Executor(ExecuteFailLogger executeFailLogger, CreateFailCounter createFailCounter, TaskCreator taskCreator,
                    TaskExecutor taskExecutor) {
        this.executeFailLogger = executeFailLogger;
        this.createFailCounter = createFailCounter;
        this.taskCreator = taskCreator;
        this.taskExecutor = taskExecutor;
    }

    public void execute(Input input){
        Cmd cmd = input.getCmd();

        if(cmd.isCreate()){
            taskCreator.create();
        }else if(cmd.isExecute()){
            taskExecutor.execute(input.getTagNum());
        }
    }
}
