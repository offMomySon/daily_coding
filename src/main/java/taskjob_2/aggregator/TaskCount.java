package taskjob_2.aggregator;

import java.util.Objects;
import lombok.Getter;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import taskjob_2.Task;

/**
 * Task 마다의 count 를 보여주기위한 view 역할의 데이터성 역할.
 */
@Getter
public class TaskCount{
    private final Task task;
    private final int count;

    public TaskCount(@NonNull Task task, int count) {
        this.task = task;
        this.count = count;
    }
}
