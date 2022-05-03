package taskjob_1.v2.command;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import taskjob_1.v2.pool.CreatedTaskPool;
import taskjob_1.v2.pool.UsableTaskPool;

/**
 * 하위의 command 객체들을 엮고, '입력받은 cmd 가 실행가능하면 cmd 를 실행한다' 라는 동일한 개념의 역할을 하는 객체
 *
 */
public class CompositedCommand implements Command{
    private final List<Command> commands;

    public CompositedCommand(List<Command> commands) {
        this.commands = validate(commands);
    }

    private List<Command> validate(List<Command> commands) {
        if (Objects.isNull(commands)) {
            throw new RuntimeException("commands 가 null 입니다.");
        }

        List<Command> newCommand = commands.stream().filter(Objects::nonNull).collect(Collectors.toUnmodifiableList());

        if (newCommand.isEmpty()) {
            throw new RuntimeException("commdnad 가 empty 입니다.");
        }

        return newCommand;
    }

    public static CompositedCommand of(Command ... commands){
        return new CompositedCommand(Arrays.stream(commands).collect(Collectors.toList()));
    }

    @Override
    public void execute(String cmd, UsableTaskPool usableTaskPool, CreatedTaskPool createdTaskPool) {
        Command command = findCommand(cmd);

        command.execute(cmd, usableTaskPool,createdTaskPool);
    }

    private Command findCommand(String cmd) {
        return commands.stream()
            .filter(_command -> _command.isExecutable(cmd))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("사용가능한 cmd 가 존재하지 않습니다."));
    }

    @Override
    public boolean isExecutable(String cmd) {
        return commands.stream()
            .anyMatch(command -> command.isExecutable(cmd));
    }

    public boolean isNotExecutable(String cmd){
        return !isExecutable(cmd);
    }
}
