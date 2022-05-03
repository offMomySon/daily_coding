package taskjob_1.v3.result;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CompositeResult implements Result{
    private final List<Result> results;

    public CompositeResult(List<Result> results) {
        this.results = validate(results);
    }

    private List<Result> validate(List<Result> results){
        if(Objects.isNull(results)){
            throw new RuntimeException("results 가 null 입니다..");
        }

        List<Result> newResults = results.stream().filter(r->Objects.nonNull(r)).collect(Collectors.toList());

        if(Objects.isNull(newResults)){
            throw new RuntimeException("results 가 비어있습니다.");
        }

        return newResults;
    }

    @Override
    public void print() {
        results.stream()
            .forEach(Result::print);
    }
}
