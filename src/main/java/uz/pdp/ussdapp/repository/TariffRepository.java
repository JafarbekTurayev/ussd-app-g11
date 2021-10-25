package uz.pdp.ussdapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ussdapp.entity.Tariff;

public interface TariffRepository extends JpaRepository<Tariff, Integer> {
    boolean existsByName(String name);
}
