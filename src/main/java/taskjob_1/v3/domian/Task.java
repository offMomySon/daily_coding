package taskjob_1.v3.domian;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

/**
 * 역할.
 * 실행될 task 를 나타내는 객체
 * value 를 통해 각각의 task 를 구분한다.
 */
public class Task implements Comparable<Task>{
    private final int value;

    public int getValue() {
        return value;
    }

    private Task(int value) {
        this.value = value;
    }

    public static Task from(@NonNull String value){
        return new Task(Integer.parseInt(value));
    }

    public static List<Task> createDefaultSystemTasks(){
        return IntStream.range(1, 10)
            .mapToObj(Task::new)
            .collect(Collectors.toList());
    }

    @Override
    public int compareTo(@NotNull Task o) {
        return this.value - o.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return value == task.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
