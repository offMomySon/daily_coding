package taskjob_2;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.commons.lang3.math.NumberUtils;
import org.jetbrains.annotations.NotNull;

/**
 * task 요구사항을 추상화한 데이터 성격의 도메인 객체.
 */
public class Task implements Comparable<Task>{
    private final int tag;

    private Task(int tag) {
        this.tag = tag;
    }

    public static Task of(String value){
        if(!NumberUtils.isParsable(value)){
            throw new RuntimeException("생성가능한 value 가 아닙니다.");
        }
        return new Task(Integer.parseInt(value));
    }

    public static List<Task> defaultSystemTasks(){
        return IntStream.range(1,10).mapToObj(Task::new).collect(Collectors.toUnmodifiableList());
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

    public String getTagAsView() {
        return Integer.toString(tag);
    }

    @Override
    public int compareTo(@NotNull Task o) {
        return tag - o.tag;
    }

    @Override
    public String toString() {
        return "Task{" +
            "value=" + tag +
            '}';
    }
}
