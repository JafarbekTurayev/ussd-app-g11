package uz.pdp.ussdapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.ussdapp.payload.ApiResponse;
import uz.pdp.ussdapp.payload.TariffDTO;
import uz.pdp.ussdapp.repository.TariffRepository;
import uz.pdp.ussdapp.service.TariffService;

@RestController
@RequestMapping("/api/tariff")
@RequiredArgsConstructor
public class TariffController {

    final TariffService tariffService;
    final TariffRepository tariffRepository;

    // raqam manager
    @PostMapping
    public HttpEntity<?> save(@RequestBody TariffDTO tariffDTO) {
        ApiResponse response = tariffService.saveTariff(tariffDTO);

        return ResponseEntity.status(response.isSuccess() ? 201 : 409).body(response);
    }
}
