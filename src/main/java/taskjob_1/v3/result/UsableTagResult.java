package taskjob_1.v3.result;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.NonNull;
import taskjob_1.v3.domian.Task;
import taskjob_1.v3.pool.TaskPool;

public class UsableTagResult implements Result{
    private static final String format = "사용가능한 TAG: %s";
    private final TaskPool usableTaskPool;

    public UsableTagResult(@NonNull TaskPool usableTaskPool) {
        this.usableTaskPool = usableTaskPool;
    }

    @Override
    public void print() {
        String result = String.format(format, createUsableResult());
        System.out.println(result);
    }

    private String createUsableResult(){
        List<Task> usableTasks = getUsableTasks();

        return usableTasks.stream()
            .sorted()
            .map(task -> task.getValue()+"")
            .collect(Collectors.joining(" "));
    }

    private List<Task> getUsableTasks(){
        return new ArrayList<>(usableTaskPool.getPoolAsView());
    }
}
