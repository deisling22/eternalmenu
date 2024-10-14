package dice.eternalmenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dice.eternalmenu.model.Rezept;

@Repository
public interface RezeptRepository extends JpaRepository<Rezept, Long> {
}
