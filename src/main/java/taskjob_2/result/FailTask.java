package taskjob_2.result;

import java.util.Objects;
import lombok.Getter;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import taskjob_2.Task;

@Getter
public class FailTask implements Comparable<FailTask>{
    private final Task task;
    private final int count;

    public FailTask(@NonNull Task task, int count) {
        this.task = task;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FailTask failTask = (FailTask) o;
        return count == failTask.count && Objects.equals(task, failTask.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, task);
    }

    @Override
    public int compareTo(@NotNull FailTask o) {
        if(count == o.count){
            return task.getTag() - o.task.getTag();
        }
        return o.count - count;
    }
}
