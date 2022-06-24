package taskjob_2.result;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import lombok.NonNull;
import taskjob_2.Task;
import taskjob_2.pool.TaskPool;

/**
 * 사용가능한 tag 를 출력하기 위한 역할.
 */
public class UsableTagResult implements ResultPrinter {
    private final List<Task> values;

    private UsableTagResult(@NonNull List<Task> values) {
        List<Task> newTasks = values.stream().collect(Collectors.toUnmodifiableList());

        this.values = newTasks;
    }

    public static UsableTagResult from(@NonNull TaskPool taskPool){
        return new UsableTagResult(taskPool.getTasks());
    }

    @Override
    public void print() {
        String result = MessageFormat.format("사용가능한 TAG: {0}", tagResult());
        System.out.println(result);
    }

    private String tagResult(){
        return values.stream()
            .map(Task::getTagAsView)
            .collect(Collectors.joining(" "));
    }
}
