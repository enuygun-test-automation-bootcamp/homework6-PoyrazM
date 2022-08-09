import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
filter , map , foreach stream
 */
public class StreamForFilterMap {
    @Test(priority = 1)
    public void arrayToListStream(){
        String[] arrays = {"a","b","c","d"};
        System.out.println(Arrays.stream(arrays).collect(Collectors.toList()));
    }

    @Test(priority = 2)
    public void streamMapForEach(){
        List<String> name = Arrays.asList("Patika.dev", "Enuygun");
        name.stream().map(s ->   s.contains("Patika.dev")).forEach(System.out::println);
        name.stream().map(s -> s.contains("Enuygun")).forEach(System.out::println);
    }

    @Test(priority = 3)
    public void streamFilter(){
        List<String> name = Arrays.asList("Patika.dev", "Enuygun", "Kodluyoruz");
        List result = name.stream().filter(s -> s.startsWith("K")).collect(Collectors.toList());
        System.out.println(result);
    }
}
