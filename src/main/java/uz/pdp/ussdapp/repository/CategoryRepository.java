package uz.pdp.ussdapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ussdapp.entity.Category;
import uz.pdp.ussdapp.entity.User;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
