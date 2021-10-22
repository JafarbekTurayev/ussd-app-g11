package uz.pdp.ussdapp.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.pdp.ussdapp.entity.Filial;
import uz.pdp.ussdapp.entity.Staff;
import uz.pdp.ussdapp.repository.FilialRepository;
import uz.pdp.ussdapp.repository.StaffRepository;
import uz.pdp.ussdapp.repository.UserRepository;

import java.util.Collections;

@Component
public class Dataloader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    FilialRepository filialRepository;

    @Autowired
    StaffRepository staffRepository;



    @Value("${spring.sql.init.mode}")
    private String initMode;

    @Override
    public void run(String... args) throws Exception {

        if (initMode.equals("always")) {
            Staff director = staffRepository.save(new Staff("Director", "director", "director"));
            Staff staff = staffRepository.save(new Staff("Xodim", "xodim", "xodim"));

            filialRepository.save(new Filial("PDP",Collections.singletonList(staff),director));

        }
    }
}
