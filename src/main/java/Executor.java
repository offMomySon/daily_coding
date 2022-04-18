public class Executor {
    private final TaskCreator taskCreator;
    private final TaskExecutor taskExecutor;

    public Executor(TaskCreator taskCreator, TaskExecutor taskExecutor) {
        this.taskCreator = taskCreator;
        this.taskExecutor = taskExecutor;
    }

    public void doExecute(Input input){
        Cmd cmd = input.getCmd();

        if(cmd.isCreate()){
            taskCreator.create();
        }else if(cmd.isExecute()){
            taskExecutor.execute(input.getTagNum());
        }
    }

    public void execute(String[] inputs){
        for(String input : inputs){
            doExecute(Input.from(input));
        }
    }
}
