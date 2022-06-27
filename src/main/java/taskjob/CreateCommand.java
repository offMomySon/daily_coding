package taskjob;

import lombok.NonNull;

public class CreateCommand implements Command{
    private final Counter createFailCounter;

    public CreateCommand(@NonNull Counter createFailCounter) {
        this.createFailCounter = createFailCounter;
    }

    @Override
    public void act(@NonNull TaskPool creatableTaskPool, @NonNull HashedTaskPool executableTaskPool) {
        if(creatableTaskPool.isEmpty()) {
            createFailCounter.increase();
            return;
        }

        Task task = creatableTaskPool.pollMinimumTask().orElseThrow(() -> new RuntimeException("task not exist."));

        executableTaskPool.add(task);
    }
}

