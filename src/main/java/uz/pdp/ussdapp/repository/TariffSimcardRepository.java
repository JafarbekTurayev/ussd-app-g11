package uz.pdp.ussdapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ussdapp.entity.Tariff;
import uz.pdp.ussdapp.entity.TariffSimcard;

import java.util.Optional;
import java.util.UUID;

public interface TariffSimcardRepository extends JpaRepository<TariffSimcard, UUID> {
    Optional<TariffSimcard> findBySimCard_Id(UUID uuid);
}
