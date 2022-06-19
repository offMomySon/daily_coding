package taskjob_2.result;

import java.util.List;
import lombok.NonNull;

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
