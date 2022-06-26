package taskjob;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class Task implements Comparable<Task>{
    private final int tag;

    private Task(int tag) {
        this.tag = tag;
    }

    public static Task from(String sNum){
        return new Task(Integer.parseInt(sNum));
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
