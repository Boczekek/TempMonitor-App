package org.example.projekt69;

import org.example.projekt69.Dane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaneRepository extends JpaRepository<Dane, Long> {
}