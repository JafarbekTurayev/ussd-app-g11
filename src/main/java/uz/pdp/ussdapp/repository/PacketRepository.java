package uz.pdp.ussdapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ussdapp.entity.Packet;
import uz.pdp.ussdapp.entity.User;
import uz.pdp.ussdapp.payload.PakaketDTO;

import java.util.UUID;

public interface PacketRepository extends JpaRepository<Packet, Integer> {

}
