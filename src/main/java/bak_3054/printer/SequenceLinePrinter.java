package bak_3054.printer;

import bak_3054.pool.Pool;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SequenceLinePrinter implements Printer {
    private final List<Printer> printers;

    public SequenceLinePrinter(List<Printer> printers) {
        this.printers = validate(printers);
    }

    private List<Printer> validate(List<Printer> printers) {
        if (Objects.isNull(printers)) {
            throw new RuntimeException("pool factory 가 null 입니다.");
        }

        List<Printer> newPools = printers.stream().filter(Objects::nonNull).collect(
            Collectors.toUnmodifiableList());

        if (newPools.isEmpty()) {
            throw new RuntimeException("pool factory 가 empty 입니다.");
        }

        return newPools;
    }

    @Override
    public void print(String cmd, Pool pool) {
        printers.stream().forEach(it -> it.print(cmd, pool));
    }

    public static class Builder {
        private List<Printer> printers = new LinkedList<>();

        public Builder nextPrinter(Printer printer) {
            printers.add(printer);
            return this;
        }

        public SequenceLinePrinter build() {
            return new SequenceLinePrinter(printers);
        }
    }
}
