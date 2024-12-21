package service.emp.openfien.Repesitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import service.emp.openfien.Entity.Commande;

import java.util.List;
@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
