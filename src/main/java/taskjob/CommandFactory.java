package taskjob;

import java.text.MessageFormat;
import lombok.NonNull;

public class CommandFactory {
    private static final String CMD_DELIMITER = " ";
    private static final int COMMAND_MIN_LENGTH = 1;
    private static final int EXECUTE_COMMAND_MIN_LENGTH = 2;

    private final Counter createFailCounter;

    public CommandFactory(@NonNull Counter createFailCounter) {
        this.createFailCounter = createFailCounter;
    }

    public Command create(String sCmd){
        String[] splitCmd = sCmd.split(CMD_DELIMITER);

        if( splitCmd.length < COMMAND_MIN_LENGTH ){
            throw new RuntimeException(MessageFormat.format("command min length is {}, current length is {}", COMMAND_MIN_LENGTH, splitCmd.length));
        }


        Cmd cmd = Cmd.find(splitCmd[0]).orElseThrow(() -> new RuntimeException("cmd not exist"));


        switch (cmd){
            case CREATE:
                return new CreateCommand(createFailCounter);
            case EXECUTE:
                if(splitCmd.length < EXECUTE_COMMAND_MIN_LENGTH){
                    throw new RuntimeException(MessageFormat.format("execute command min length is {}, current length is {}", EXECUTE_COMMAND_MIN_LENGTH, splitCmd.length));
                }
                Task requestTask = Task.from(splitCmd[1]);
                return new ExecuteCommand(requestTask);
        }

        throw new RuntimeException(MessageFormat.format("fail to create cmd. sCmd is `{}`", sCmd));
    }
}
