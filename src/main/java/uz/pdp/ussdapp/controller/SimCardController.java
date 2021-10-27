package uz.pdp.ussdapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ussdapp.payload.ApiResponse;
import uz.pdp.ussdapp.payload.RegisterDTO;
import uz.pdp.ussdapp.payload.SimCardDto;
import uz.pdp.ussdapp.service.SimCardService;

import java.util.UUID;

@RestController
@RequestMapping("/api/simCard")
public class SimCardController {
    @Autowired
    SimCardService simCardService;

    @PostMapping
    public HttpEntity<?> add(@RequestBody RegisterDTO registerDTO) {
        ApiResponse apiResponse = simCardService.add(registerDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PostMapping("/{id}")
    public HttpEntity<?> changeTariff(@PathVariable UUID id, @RequestParam Integer tariffId) {
        ApiResponse response = simCardService.changeTariff(id, tariffId);
        return ResponseEntity.status(response.isSuccess() ? 200 : 404).body(response);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable UUID id) {
        ApiResponse apiResponse = simCardService.getById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }

    @PostMapping("/addSimcard")
    public HttpEntity<?> addSimCard(@RequestBody SimCardDto simCardDto) {
        ApiResponse apiResponse = simCardService.addSimCard(simCardDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }

    @GetMapping
    public HttpEntity<?> getAll() {
        ApiResponse apiResponse = simCardService.getAll();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable UUID id, @RequestBody SimCardDto simCardDto) {
        ApiResponse apiResponse = simCardService.edit(id, simCardDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }

    @DeleteMapping
    public HttpEntity<?> delete(@PathVariable UUID id) {
        ApiResponse apiResponse = simCardService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }
}
