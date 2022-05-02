package taskjob_1.v3.command.factory;

import lombok.NonNull;
import taskjob_1.v3.command.Command;
import taskjob_1.v3.pool.HashedTaskPool;
import taskjob_1.v3.pool.TaskPool;

public abstract class CommandFactory {

    public abstract Command create(String cmd);

    public abstract boolean isCreatable(String cmd);
}
