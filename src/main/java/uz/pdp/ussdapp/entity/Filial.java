package uz.pdp.ussdapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.ussdapp.entity.template.AbsEntity;
import uz.pdp.ussdapp.entity.template.AbsNameEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Filial extends AbsEntity {
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "filial")
    private List<Staff> staffList;

    @OneToOne
    private Staff director;

}
