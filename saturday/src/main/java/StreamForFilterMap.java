import org.testng.annotations.Test;

import java.util.Arrays;
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
    public void streamMap(){

    }

    @Test(priority = 3)
    public void streamFilter(){

    }

    @Test(priority = 4)
    public void streamForEach(){

    }
}
