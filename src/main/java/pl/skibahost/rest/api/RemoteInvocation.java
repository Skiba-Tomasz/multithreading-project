package pl.skibahost.rest.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.skibahost.job.SequentialSearch;

@RestController
@RequestMapping("/rmi")
public class RemoteInvocation {

    @GetMapping("/sequential")
    public boolean test(@RequestParam String keyWord){
        SequentialSearch sequentialSearch = new SequentialSearch(keyWord);
        sequentialSearch.execute();
        return true;
    }
}
