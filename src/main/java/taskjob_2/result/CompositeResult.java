package taskjob_2.result;

import java.util.List;
import lombok.NonNull;

/**
 * 결과를 print 하는 책임을 가지고 있다.
 *
 * n 개의 동일한 printer 개념을 하나의 printer 개념으로 사용하기 위한 객체.
 */
public class CompositeResult implements ResultPrinter{
    private final List<ResultPrinter> resultPrinters;

    public CompositeResult(@NonNull List<ResultPrinter> resultPrinters) {
        this.resultPrinters = resultPrinters;
    }

    @Override
    public void print() {
        resultPrinters.forEach(ResultPrinter::print);
    }
}
