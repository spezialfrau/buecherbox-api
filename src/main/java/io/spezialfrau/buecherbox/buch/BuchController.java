package io.spezialfrau.buecherbox.buch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/api/buecher"))
@Slf4j
public class BuchController {

    private final BuchRepository repository;

    public BuchController(BuchRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @ResponseBody
    public List<Buch> getBuecher() {
        List<Buch> buecherliste = repository.findAll();
        return buecherliste;
    }

    @PostMapping
    public ResponseEntity addBuch(@RequestBody Buch buch) {
        Buch b = repository.save(buch);
        return ResponseEntity.ok(b);
    }
}
