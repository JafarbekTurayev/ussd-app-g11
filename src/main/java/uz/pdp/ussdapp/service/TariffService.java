package uz.pdp.ussdapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.ussdapp.entity.Tariff;
import uz.pdp.ussdapp.entity.enums.UserType;
import uz.pdp.ussdapp.payload.ApiResponse;
import uz.pdp.ussdapp.payload.TariffDTO;
import uz.pdp.ussdapp.repository.TariffRepository;
import uz.pdp.ussdapp.repository.TariffSimcardRepository;

@Service
public class TariffService {
    @Autowired
    TariffRepository tariffRepository;

    public ApiResponse saveTariff(TariffDTO tariffDTO) {

        if (tariffRepository.existsByName(tariffDTO.getName())) return new ApiResponse("Bunday tariff bor", false);

        Tariff tariff = new Tariff(
                tariffDTO.getName(),
                UserType.valueOf(tariffDTO.getUserType()),
                tariffDTO.getPrice(),
                tariffDTO.getSwitchPrice(),
                tariffDTO.getExpire(),
                tariffDTO.getTariffSMS(),
                tariffDTO.getTariffMB(),
                tariffDTO.getTariffDAQ(),
                tariffDTO.getSmsPrice(),
                tariffDTO.getMbPrice(),
                tariffDTO.getDaqPrice());

        tariffRepository.save(tariff);
        return new ApiResponse("Saved!", true);

    }
}
