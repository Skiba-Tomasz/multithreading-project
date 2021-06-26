package pl.skibahost.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.skibahost.file.DictionarySplitter;
import pl.skibahost.job.MultiThreadSearch;
import pl.skibahost.job.Omp4jJob;
import pl.skibahost.job.SequentialSearch;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/rmi")
public class RemoteInvocation {

    @GetMapping("/sequential")
    public ResponseEntity sequential(@RequestParam @NotNull String keyWord){
        if(keyWord.isBlank())
            return ResponseEntity.badRequest().body("Keyword can not be null!");
        SequentialSearch sequentialSearch = new SequentialSearch(keyWord);
        sequentialSearch.execute();
        return ResponseEntity.ok("Method invoked");
    }

    @GetMapping("/multithreading")
    public ResponseEntity multithreading(@RequestParam @NotNull Integer threadCount, @RequestParam @NotNull String keyWord){
        if(keyWord.isBlank())
            return ResponseEntity.badRequest().body("Keyword can not be null!");
        new DictionarySplitter(threadCount).run();
        MultiThreadSearch multiThreadSearch = new MultiThreadSearch(threadCount, keyWord);
        multiThreadSearch.execute();
        return ResponseEntity.ok("Method invoked");
    }


    @GetMapping("/omp4j")
    public ResponseEntity omp4j(@RequestParam @NotNull Integer threadCount, @RequestParam @NotNull String keyWord){
        if(keyWord.isBlank())
            return ResponseEntity.badRequest().body("Keyword can not be null!");
        new DictionarySplitter(threadCount).run();
        Omp4jJob omp4jJob = new Omp4jJob(threadCount, keyWord);
        omp4jJob.execute();
        return ResponseEntity.ok("Method invoked");
    }
}
