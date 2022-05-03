package taskjob_1.v3.result;

import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import taskjob_1.v3.domian.Task;

public class FailTask implements Comparable<FailTask>{
    private final int count;
    private final Task task;

    public FailTask(int count, @NonNull Task task) {
        this.count = count;
        this.task = task;
    }

    public int getCount() {
        return count;
    }

    public Task getTask() {
        return task;
    }

    @Override
    public int compareTo(@NotNull FailTask o) {
        if(this.count == o.count){
            return this.task.getValue() - o.task.getValue();
        }

        return o.count - this.count;
    }
}
