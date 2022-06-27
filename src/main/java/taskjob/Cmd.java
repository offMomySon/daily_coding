package taskjob;

import java.util.Arrays;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

public enum Cmd {
    CREATE("create"), EXECUTE("execute");

    private final String value;
    Cmd(String value) {
        this.value = value;
    }

    public static Optional<Cmd> find(String sCmd){
        return Arrays.stream(values())
            .filter(c ->  StringUtils.equalsIgnoreCase(c.value, sCmd))
            .findAny();
    }
}
