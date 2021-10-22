package uz.pdp.ussdapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ussdapp.entity.Payment;
import uz.pdp.ussdapp.entity.User;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {

}
