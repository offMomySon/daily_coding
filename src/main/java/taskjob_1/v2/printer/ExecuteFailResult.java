package taskjob_1.v2.printer;


import java.util.stream.Collectors;
import lombok.NonNull;
import taskjob_1.v2.aggregate.ExecuteFailCounter;

/**
 * 실행에 실패한 task 의 tag, count 를 출력하는 역할, view 역할.
 * 지정된 format 에 맞게 출력을 한다.
 *
 * 실행 실패 데이터를 ExecuteFailCounter 에서 가져온다.
 */
public class ExecuteFailResult implements Result {
    private static final String resultFormat = "TASK 수행 실패한 태그 : %s";

    private final ExecuteFailCounter executeFailCounter;

    public ExecuteFailResult(@NonNull ExecuteFailCounter executeFailCounter) {
        this.executeFailCounter = executeFailCounter;
    }

    @Override
    public String create() {
        return String.format(resultFormat, createExecuteFailResult());
    }

    public String createExecuteFailResult(){
        return executeFailCounter.getFailTask1().stream()
            .sorted()
            .map(failTask -> failTask.getTask().getValue() + "(" + failTask.getCount() + ")")
            .collect(Collectors.joining(" "));
    }
}
