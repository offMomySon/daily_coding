package taskjob;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

public class Task implements Comparable<Task>{
    private final int tag;

    private Task(int tag) {
        this.tag = tag;
    }

    public static Task from(@NonNull String sNum){
        return new Task(Integer.parseInt(sNum));
    }

    public static List<Task> systemDefaultTasks(){
        return IntStream.range(1, 10).mapToObj(Task::new).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return tag == task.tag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag);
    }

    @Override
    public int compareTo(@NotNull Task o) {
        return this.tag - o.tag;
    }
}
