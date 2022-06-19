package taskjob_2.aggregator;

import java.util.Objects;
import lombok.Getter;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import taskjob_2.Task;

@Getter
public class TaskCount{
    private final Task task;
    private final int count;

    public TaskCount(@NonNull Task task, int count) {
        this.task = task;
        this.count = count;
    }
}
