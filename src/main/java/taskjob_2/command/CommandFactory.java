package taskjob_2.command;

import lombok.NonNull;
import taskjob_2.aggregator.Counter;
import taskjob_2.Task;
import taskjob_2.aggregator.TaskCounter;

public class CommandFactory {
    private static final String CMD_DELIMITER = " ";

    private final Counter createFailCounter;
    private final TaskCounter executeFailCounter;

    public CommandFactory(@NonNull Counter createFailCounter, @NonNull TaskCounter executeFailCounter) {
        this.createFailCounter = createFailCounter;
        this.executeFailCounter = executeFailCounter;
    }

    public Command create(String sCmd){
        String[] spitCmd = sCmd.split(CMD_DELIMITER);

        Cmd cmd = Cmd.find(spitCmd[0]).orElseThrow(()-> new RuntimeException("not exist cmd."));

        if(cmd == Cmd.CREATE){
            return new CreateCommand(createFailCounter);
        }

        if(cmd == Cmd.EXECUTE){
            Task requestTask = Task.of(spitCmd[1]);

            return new ExecuteCommand(executeFailCounter, requestTask);
        }

        throw new RuntimeException("not exits usable Command object.");
    }
}
