package taskjob_1;

import java.util.Objects;

public class FailTask {
    private final Task task;
    private final int count;

    public FailTask(Task task, int count) {
        this.task = task;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FailTask failTask = (FailTask) o;
        return task.equals(failTask.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task);
    }
}
