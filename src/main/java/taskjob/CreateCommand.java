package taskjob;

import java.util.Optional;
import lombok.NonNull;

public class CreateCommand implements Command{

    @Override
    public void act(@NonNull TaskPool creatableTaskPool, @NonNull HashedTaskPool executableTaskPool) {
        if(creatableTaskPool.isEmpty()) {
            return;
        }

        Task task = creatableTaskPool.pollMinimumTask().orElseThrow(() -> new RuntimeException("task not exist."));

        executableTaskPool.add(task);
    }
}

