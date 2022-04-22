package taskjob_1;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.NonNull;

public class Task {
    private final String value;

    public Task(@NonNull String value) {
        this.value = value;
    }

    public static Task from(int n) {
        return new Task(n + "");
    }

    public static List<Task> createSystemDefaultTasks() {
        return IntStream
            .rangeClosed(1, 9)
            .mapToObj(Task::from)
            .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(value, task.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
