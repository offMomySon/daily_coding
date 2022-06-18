package taskjob_2;

import java.util.Arrays;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

/**
 * 입력 받는 cmd 를 제한하기 위한 역할.
 */
public enum Cmd {
    CREATE("CREATE"), EXECUTE("EXECUTE");

    private final String value;

    Cmd(String value) {
        this.value = value;
    }

    public static Optional<Cmd> find(String sCmd){
        return Arrays.stream(values())
            .filter(cmd -> StringUtils.equalsIgnoreCase(cmd.value, sCmd))
            .findAny();
    }
}
