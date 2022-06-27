package taskjob;

import lombok.NonNull;

public interface Command {
    void act(@NonNull TaskPool creatableTaskPool, @NonNull HashedTaskPool executableTaskPool);
}
