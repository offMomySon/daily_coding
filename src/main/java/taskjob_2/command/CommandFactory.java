package taskjob_2.command;

import lombok.NonNull;
import taskjob_2.aggregator.Counter;
import taskjob_2.Task;
import taskjob_2.aggregator.TaskCounter;

/**
 * command 객체를 생성하는 역할. ( 당연한 이야기 이지만, 생성의 책임을 지니고 있다. )
 *
 * string command 의 데이터로 부터,
 * 동일한 interface 의 command 객체들을 생성하는 역할.
 */
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
