package taskjob_2;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * task 요구사항을 추상화한 데이터 역할.
 */
public class Task {
    private final int value;

    private Task(int value) {
        this.value = value;
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
        return value == task.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
