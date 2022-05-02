package taskjob_1.v3.command.factory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import taskjob_1.v3.command.Command;

public class CompositeCommandFactory extends CommandFactory{
    private final List<CommandFactory> commandFactories;

    public CompositeCommandFactory(List<CommandFactory> commandFactories) {
        this.commandFactories = validate(commandFactories);
    }

    private static List<CommandFactory> validate(List<CommandFactory> commandFactories){
        if(Objects.isNull(commandFactories)){
            throw new RuntimeException("commandFactories 가 null 입니다.");
        }

        List<CommandFactory> newCommandFactories = commandFactories.stream().filter(Objects::nonNull).collect(Collectors.toList());

        if(newCommandFactories.isEmpty()){
            throw new RuntimeException("commandFactories 가 empty 입니다.");
        }

        return newCommandFactories;
    }

    @Override
    public Command create(String cmd) {
        return commandFactories.stream()
            .filter(c->c.isCreatable(cmd))
            .findFirst()
            .map(f->f.create(cmd))
            .orElseThrow(()-> new RuntimeException("생성 가능한 명령어가 없습니다."));
    }

    @Override
    public boolean isCreatable(String cmd) {
        return commandFactories.stream()
            .anyMatch(c->c.isCreatable(cmd));
    }
}
