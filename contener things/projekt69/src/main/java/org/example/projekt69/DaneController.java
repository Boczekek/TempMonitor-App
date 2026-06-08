package org.example.projekt69;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/api/pomiary")
@CrossOrigin(origins = "*") // WAŻNE: Pozwala na łączenie się z różnych domen (np. przez przeglądarkę)
public class DaneController {

    private final DaneRepository repository;

    public DaneController(DaneRepository repository) {
        this.repository = repository;
    }

    // Pobieranie wszystkich danych (dla Mobile i Web)
    @GetMapping
    public List<Dane> getAll() {
        return repository.findAll();
    }

    // Zapisywanie danych do bazy SQL
 //   @PostMapping
  //  public Dane create(@RequestBody Dane nowyPomiar) {
   //     return repository.save(nowyPomiar);
  //  }

    @PostMapping("/arduino")
    public ResponseEntity<String> receiveFromArduino(@RequestBody Dane data) {
        // Arduino wysyła np. tylko {"temperatura": 22.5}
        // Serwer sam ustawia aktualny czas i datę:
        data.setData(java.time.LocalDate.now(ZoneId.of("Europe/Warsaw")));
        data.setGodzina(java.time.LocalTime.now(ZoneId.of("Europe/Warsaw")));

        // Zapis do bazy SQL
        repository.save(data);

        // Odpowiedź dla Arduino (opcjonalna, ale przydatna do debugowania)
        return ResponseEntity.ok("Dane zapisane do MySQL! Odebrano: " + data.getTemperatura());
    }
}