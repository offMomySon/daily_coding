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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskCount taskCount = (TaskCount) o;
        return count == taskCount.count && Objects.equals(task, taskCount.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, task);
    }
}
