package euler54.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ListUtils {

    public static <T> Set<T> findDuplicates(List<T> list) {
        Set<T> seen = new HashSet<>();
        return list.stream()
                .filter(e -> !seen.add(e))
                .collect(Collectors.toSet());
    }

    public static <T> T findLastElementFromSet(Set<T> set) {
         Optional<T> lastElement = set.stream()
                                 .reduce((a, b) -> b);

        return lastElement.orElse(null);
    }
}
