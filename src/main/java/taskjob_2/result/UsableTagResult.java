package taskjob_2.result;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import lombok.NonNull;
import taskjob_2.Task;

/**
 * 사용가능한 tag 를 출력하기 위한 역할.
 */
public class UsableTagResult implements ResultPrinter {
    private final List<Task> values;

    public UsableTagResult(@NonNull List<Task> values) {
        this.values = values;
    }

    @Override
    public void print() {
        String result = MessageFormat.format("사용가능한 TAG: {0}", tagResult());
        System.out.println(result);
    }

    private String tagResult(){
        return values.stream()
            .map(Task::getTagAsView)
            .collect(Collectors.joining(" "));
    }
}
