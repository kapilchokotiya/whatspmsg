package com.twiliowhatsapp.api.controller;
import com.twiliowhatsapp.api.payload.WhatsAppRequestDTO;
import com.twiliowhatsapp.api.service.TwilioWhatsAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/whatsapp")
public class WhatsAppController {

    private final TwilioWhatsAppService twilioWhatsAppService;

    @Autowired
    public WhatsAppController(TwilioWhatsAppService twilioWhatsAppService) {
        this.twilioWhatsAppService = twilioWhatsAppService;
    }
    //http://localhost:8080/whatsapp/send
    @PostMapping("/send")
    @ResponseStatus(HttpStatus.OK)
    public void sendWhatsAppMessage(@RequestBody WhatsAppRequestDTO requestDTO) {
        twilioWhatsAppService.sendWhatsAppMessage(requestDTO.getTo(), requestDTO.getMessage());
    }
}
