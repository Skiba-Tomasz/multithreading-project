package pl.skibahost.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.skibahost.AppState;

@RestController
@RequestMapping("results")
public class Results {

    @GetMapping
    public ResponseEntity getResults(){
        return ResponseEntity.ok(AppState.getInstance().results);
    }
}
