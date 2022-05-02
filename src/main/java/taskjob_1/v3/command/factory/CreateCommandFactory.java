package taskjob_1.v3.command.factory;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import taskjob_1.v3.aggregator.Counter;
import taskjob_1.v3.command.Command;
import taskjob_1.v3.command.CreateCommand;

public class CreateCommandFactory extends CommandFactory{
    private static final String cmd = "create";

    private final Counter createFailCounter;

    public CreateCommandFactory(@NonNull Counter createFailCounter) {
        this.createFailCounter = createFailCounter;
    }

    @Override
    public Command create(String cmd) {
        return new CreateCommand(createFailCounter);
    }

    @Override
    public boolean isCreatable(String cmd) {
        return StringUtils.equals(cmd, this.cmd);
    }
}
