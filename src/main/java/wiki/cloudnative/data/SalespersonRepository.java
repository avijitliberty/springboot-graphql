package wiki.cloudnative.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalespersonRepository extends JpaRepository<Salesperson, Long> {

    Salesperson findSalespersonByEmail(String email);
}