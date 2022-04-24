package taskjob_1.v2.printer;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 *  단일 instance 인 compsitePrinter 가 '메세지를 출력한다' 라는 개념을 가지고 있는 하위 printer 객체들을 엮고,
 *  엮은 하위 객체들을 이용해서 동일한 개념의 '메세지를 출력한다' 라는 개념을 구현.
 *
 *  메세지 출력의 역할.
 */
public class CompositeResult implements Result {
    private final List<Result> resultResults;

    private CompositeResult(List<Result> resultResults) {
        this.resultResults = validate(resultResults);
    }

    public static CompositeResult of(Result ... results){
        return new CompositeResult(Arrays.stream(results).collect(Collectors.toList()));
    }

    private List<Result> validate(List<Result> results){
        if(Objects.isNull(results)){
            throw new RuntimeException("printers 가 null 입니다.");
        }

        List<Result> newResults = results.stream().filter(Objects::nonNull).collect(Collectors.toUnmodifiableList());

        if(newResults.isEmpty()){
            throw new RuntimeException("printer 가 empty 입니다.");
        }

        return newResults;
    }

    @Override
    public String create() {
        return resultResults.stream()
            .map(result -> result.create() + "\n")
            .reduce("", (result1, result2) -> result1+result2);
    }
}
