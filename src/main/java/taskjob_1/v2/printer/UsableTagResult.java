package taskjob_1.v2.printer;

import java.util.stream.Collectors;
import lombok.NonNull;
import taskjob_1.v2.domain.Task;
import taskjob_1.v2.pool.UsableTaskPool;

/**
 * 사용가능한 tag 리스트를 보여주는 view 객체.
 * view 의 역할을 가지고 있다.
 */
public class UsableTagResult implements Result {
    private static final String resultFormat = "사용가능한 TAG: %s";

    private final UsableTaskPool usableTaskPool;

    public UsableTagResult(@NonNull UsableTaskPool usableTaskPool) {
        this.usableTaskPool = usableTaskPool;
    }

    @Override
    public String create() {
        return String.format(resultFormat, createUsableTaskResult());
    }

    private String createUsableTaskResult(){
        return usableTaskPool.getTasks().stream().sorted().map(Task::getValue).collect(Collectors.joining(" "));
    }
}
