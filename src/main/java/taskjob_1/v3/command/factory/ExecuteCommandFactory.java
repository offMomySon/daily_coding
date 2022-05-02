package taskjob_1.v3.command.factory;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import taskjob_1.v3.aggregator.TaskCounter;
import taskjob_1.v3.command.Command;
import taskjob_1.v3.command.ExecuteCommand;
import taskjob_1.v3.domian.Task;

public class ExecuteCommandFactory extends CommandFactory {
    private static final String cmd = "execute";

    private final TaskCounter executeFailCounter;

    public ExecuteCommandFactory(@NonNull TaskCounter executeFailCounter) {
        this.executeFailCounter = executeFailCounter;
    }

    @Override
    public Command create(String cmd) {
        String[] cmds = cmd.split(" ");

        Task task = Task.from(cmds[1]);

        return new ExecuteCommand(task, executeFailCounter);
    }

    @Override
    public boolean isCreatable(String cmd) {
        String[] cmds = cmd.split(" ");
        String command = cmds[0];
        String numeric = cmds[1];

        return StringUtils.equals(command, this.cmd) && StringUtils.isNumeric(numeric) ;
    }
}
