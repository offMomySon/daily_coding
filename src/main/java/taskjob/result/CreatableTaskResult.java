package taskjob.result;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import lombok.NonNull;
import taskjob.Task;
import taskjob.pool.TaskPool;

public class CreatableTaskResult implements TaskResult {
    private static final String TAG_NUM_DELIMITER = " ";
    private final List<Task> tasks;

    private CreatableTaskResult(@NonNull List<Task> tasks) {
        this.tasks = tasks;
    }

    public static CreatableTaskResult from(@NonNull TaskPool taskPool){
        List<Task> creatableTasks = taskPool.getTasksAsView().stream().sorted().collect(Collectors.toUnmodifiableList());

        return new CreatableTaskResult(creatableTasks);
    }

    public String getResult(){
        return MessageFormat.format("사용가능한 TAG : {0}", createTaskNumsResult() );
    }

    private String createTaskNumsResult(){
        return tasks.stream().map(Task::getAsView).collect(Collectors.joining(TAG_NUM_DELIMITER));
    }
}
