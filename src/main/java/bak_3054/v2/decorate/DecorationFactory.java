package bak_3054.v2.decorate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DecorationFactory {

    // 사용자의 요구사항이 담겼다 OK?
    // factory 에서는 담겨도 괜찮을까? -> 안될꺼 같은데
    // 도메인 객체에서만 담겨야하지 않나?
    // 어떻게 더숨기지?
    public List<Decoration> create(int len) {
        return IntStream.range(0, len)
            .mapToObj(index -> (index + 1) % 3 == 0 ? Decoration.wendy : Decoration.piterpan)
            .collect(Collectors.toList());
    }

    public List<Decoration> create(String str) {
        return IntStream.range(0, str.length())
            .mapToObj(index -> Decoration.text(str.charAt(index)))
            .collect(Collectors.toList());
    }

}
