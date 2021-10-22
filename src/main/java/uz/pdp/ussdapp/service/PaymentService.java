package uz.pdp.ussdapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.ussdapp.entity.Payment;
import uz.pdp.ussdapp.entity.SimCard;
import uz.pdp.ussdapp.entity.enums.PayType;
import uz.pdp.ussdapp.payload.ApiResponse;
import uz.pdp.ussdapp.payload.PaymentDTO;
import uz.pdp.ussdapp.repository.PaymentRepository;
import uz.pdp.ussdapp.repository.SimcardRepository;

import java.util.Date;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    SimcardRepository simcardRepository;


    public ApiResponse add(PaymentDTO paymentDTO) {

        //+998 91 2455897
        if (paymentDTO.getPhoneNumber().startsWith("+998") && paymentDTO.getPhoneNumber().length() == 13) {
            boolean exists = simcardRepository.existsByCodeAndNumber(
                    paymentDTO.getPhoneNumber().substring(4, 6),
                    paymentDTO.getPhoneNumber().substring(6));

            Optional<SimCard> optionalSimCard = simcardRepository.findByCodeAndNumber(
                    paymentDTO.getPhoneNumber().substring(4, 6),
                    paymentDTO.getPhoneNumber().substring(6));

            if (!exists) return new ApiResponse("Bunday raqam tizimda mavjud emas!", false);


            SimCard simCard = optionalSimCard.get();
            simCard.setBalance(simCard.getBalance() + paymentDTO.getAmount());


            Payment payment = new Payment();
            payment.setAmount(paymentDTO.getAmount());
            payment.setDate(new Date());
            payment.setNumber(paymentDTO.getPhoneNumber());
            payment.setPayType(PayType.valueOf(paymentDTO.getType()));
            paymentRepository.save(payment);
            simcardRepository.save(simCard);
            return new ApiResponse("Success", true);
        }
        return new ApiResponse("Phone number pattern wrong!", false);

    }
}
