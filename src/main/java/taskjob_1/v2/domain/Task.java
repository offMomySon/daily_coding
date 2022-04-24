package taskjob_1.v2.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;


/**
 * 이 객체가 필요한 이유는 사용자의 요구사항 변화에 의해 시스템의 변경을 막기위해 필요하다.
 *
 * int 를 task 의 식별 방법으로 사용하였다면,
 * 요구사항인 사용자의 task 식별 방법의 변화( index -> char ) 시, Task 객체 변해야하고 Task 객체 변화로 인해 다른 객체에도 영향을 미치게 된다.
 *
 * String 을 사용함으로써, 사용자의 요구사항 변화에도 유연하게 대처 가능하다.
 */
public class Task implements Comparable<Task>{
    private final String value;

    public Task(@NonNull String value) {
        this.value = value;
    }

    /**
     * 변환하는 것을 감추는 이유는,
     * 내부 값에 상관없이 외부 객체에서 다루기 위해.
     */
    public static Task from(char ch){
        return new Task(ch + "");
    }

    public static Task from(int num){
        return new Task(num + "");
    }

    /**
     * System default 로 존재하는 tasks 을 생성하고,
     * pool 에 등록하기 위해서
     */
    public static List<Task> createSystemDefaultTasks(){
        return IntStream.range(1, 10)
            .mapToObj(Task::from)
            .collect(Collectors.toList());
    }

    public String getValue() {
        return value;
    }

    // TODO
    /**
     * pool 에서 오름 차순으로 정렬하기 위해서.
     */
    /**
     * Task 가 가지고있는 value 의 자료형이 String 이다.
     * compare to 로 비교하면 사전순으로 정렬되기 때문에 의도와 다르게 동작한다.
     * tag num 11, 2 비교시  더큰 숫자인 11 이 앞에 출력된다. (ex) [ 11(1) 2(1) ]
     *
     * 어쩔수 없이 Interger 로 변환하고 비교하였다.
     * -> 원래 자료형을 변형해서 비교하기 때문에 안좋다..
     * -> tag 의 범용성을 생각해서 String 을 했지만 안좋네..ㅜ
     */
    /**
     * methoad 를 꺼내와서 사용하고하는 방법이 신기하다.
     * task 의 value 를 string 으로 가져오고 value 를 integer 로 변혼하였다.
     * -> 이럴 바에는 Task 의 value 의 자료형 int 로의 변경 좋지 않나?
     */
    @Override
    public int compareTo(@NotNull Task o) {
        int thisValue = Integer.parseInt(this.value);
        int outValue = Integer.parseInt(o.value);

        return Integer.compare(thisValue, outValue);
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

    @Override
    public String toString() {
        return "Task{" +
            "value='" + value + '\'' +
            '}';
    }
}
