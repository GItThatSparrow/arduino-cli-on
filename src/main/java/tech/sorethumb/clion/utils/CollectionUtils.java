package tech.sorethumb.clion.utils;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CollectionUtils {
    
    public static <T> Predicate<T> distinctByKey (Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
    
    public static <T> Collector<T,?, List<T>> toSortedList() {
        return Collectors.collectingAndThen(toList(),
                l -> l.stream().sorted().collect(toList()));
    }
}
