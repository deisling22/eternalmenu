package dice.eternalmenu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dice.eternalmenu.model.Rezept;
import dice.eternalmenu.repository.RezeptRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/rezepte")
public class RezeptController {

    @Autowired
    private RezeptRepository rezeptRepository;

    // GET-Endpunkt zum Abrufen eines Rezepts
    @GetMapping("/{id}")
    public ResponseEntity<Rezept> getRezept(@PathVariable Long id) {
        Optional<Rezept> rezept = rezeptRepository.findById(id);
        if (rezept.isPresent()) {
            return ResponseEntity.ok(rezept.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST-Endpunkt zum Hinzufügen eines neuen Rezepts
    @PostMapping
    public ResponseEntity<Rezept> createRezept(@RequestBody Rezept rezept) {
        Rezept savedRezept = rezeptRepository.save(rezept);
        return ResponseEntity.ok(savedRezept);
    }
}
