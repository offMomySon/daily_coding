package taskjob_1.v2.aggregate;

import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import taskjob_1.v2.domain.Task;

/**
 * 역할
 * Task 의 실패 횟수 집계를 위한 dto 형 class
 *
 * dto 클래스에 increase 같은 연산이 있어도 될까?
 */
public class FailTask implements Comparable<FailTask>{
    private final Task task;
    private final int count;

    public FailTask(@NonNull Task task, int count) {
        this.task = task;
        this.count = count;
    }

    public Task getTask() {
        return task;
    }

    public int getCount() {
        return count;
    }

    public FailTask increaseCount(){
        return new FailTask(this.task, this.count +1);
    }


    //TODO
    /**
     * Task 가 가지고있는 value 의 자료형이 String 이다.
     * compare to 로 비교하면 사전순으로 정렬되기 때문에 의도와 다르게 동작한다.
     * tag num 11, 2 비교시  더큰 숫자인 11 이 앞에 출력된다. (ex) [ 11(1) 2(1) ]
     *
     * 어쩔수 없이 Interger 로 변환하고 비교하였다.
     * -> 원래 자료형을 변형해서 비교하기 때문에 안좋다..
     * -> tag 의 범용성을 생각해서 String 을 했지만 안좋네..ㅜ
     *
     * Task 의 tag 개념 (= value) 을 stirng 으로 표현 했다.
     * 생성 관점.
     * Task 생성시 value 로  int, char 을 준다면 Stirng 으로 변환하고 생성하기 쉽다.
     *
     * 정렬 관점.
     * 하지만 정렬시, value 의 자료형이 string 인 관계로, int, char 과는  compareTo 의 동작이 다르기 때문에 int ,ch 와 결과가 다르게 생성된다.. ( string 은 사정순, int,ch 는 크기순 )
     *
     * Trade off.
     * Task 안의 instance value, value 의 자료형  string vs char, int 중 어느 하나의 선택시 이런 trade off 를 생각해야 한다.
     *
     * string 의 경우 , int, ch 중 어떤것이 들어와도 string 에 매핑하면 되기 때문에 생성이 쉽다. sort 가 사용되는 모든 코드를 확인해야한다.( 의도와 다른 comapreto 가 실행 될 수 있다.
     * value 의 경우 int, char 을 param 으로 받았다면 생성에 실패한다. -> 생성이 어렵다.
     */
    @Override
    public int compareTo(@NotNull FailTask o) {
        if(this.count == o.count){
            int thisValue = Integer.parseInt(this.task.getValue());
            int outValue = Integer.parseInt(o.task.getValue());

            return Integer.compare(thisValue, outValue);
        }

        return Integer.compare(o.count , this.count);
    }
}
