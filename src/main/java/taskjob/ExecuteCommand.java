package taskjob;

import java.util.Optional;
import lombok.NonNull;

public class ExecuteCommand implements Command{
    private final Task requestTask;

    public ExecuteCommand(@NonNull Task requestTask) {
        this.requestTask = requestTask;
    }

    @Override
    public void act(@NonNull TaskPool creatableTaskPool, @NonNull HashedTaskPool executableTaskPool) {
        if(executableTaskPool.notContain(requestTask)) {
            return;
        }

        Task task = executableTaskPool.poll(requestTask).orElseThrow(()-> new RuntimeException("task not exist."));

        creatableTaskPool.add(task);
    }
}