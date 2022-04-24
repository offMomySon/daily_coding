package taskjob_1.v2.printer;

import lombok.NonNull;
import taskjob_1.v2.aggregate.CreateFailCounter;

/**
 * task 생성에 실패 결과를 출력하기 위한 역할. view 의 역할이다.
 *
 * createFailCounter 에서 실패 횟수를 가져오고, 결과 포멧에 맞게 출력한다.
 */
public class CreateFailResult implements Result {
    private final static String resultFormat = "TASK 생성 실패: %s";

    private final CreateFailCounter createFailCounter;

    public CreateFailResult(@NonNull CreateFailCounter createFailCounter) {
        this.createFailCounter = createFailCounter;
    }

    @Override
    public String create() {
        return String.format(resultFormat, createFailCounter.getCount());
    }
}
