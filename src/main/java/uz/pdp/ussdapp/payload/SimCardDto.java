package uz.pdp.ussdapp.payload;

import lombok.Data;
import uz.pdp.ussdapp.entity.Packet;

import java.util.Date;
import java.util.List;

@Data
public class SimCardDto {
    private String code;
    private String number;
    private List<Integer> packetList;
}
