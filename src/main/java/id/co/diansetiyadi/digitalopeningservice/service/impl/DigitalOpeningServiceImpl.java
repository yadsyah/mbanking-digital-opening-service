package id.co.diansetiyadi.digitalopeningservice.service.impl;

import com.google.gson.Gson;
import id.co.diansetiyadi.digitalopeningservice.dto.request.SubmitApplyOpeningRequest;
import id.co.diansetiyadi.digitalopeningservice.dto.request.ValidationApplyOpeningRequest;
import id.co.diansetiyadi.digitalopeningservice.dto.response.SubmitApplyOpeningResponse;
import id.co.diansetiyadi.digitalopeningservice.dto.response.ValidationApplyOpeningResponse;
import id.co.diansetiyadi.digitalopeningservice.service.DigitalOpeningService;
import id.co.diansetiyadi.digitalopeningservice.util.DigitalOpeningConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DigitalOpeningServiceImpl implements DigitalOpeningService {

    private final Gson gson;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public DigitalOpeningServiceImpl(Gson gson, KafkaTemplate<String, String> kafkaTemplate) {
        this.gson = gson;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendNotification() {

    }

    @Override
    public SubmitApplyOpeningResponse submitApplication(SubmitApplyOpeningRequest request) {
        return null;
    }

    @Override
    public ValidationApplyOpeningResponse validationApply(ValidationApplyOpeningRequest request) {
        return null;
    }

    private void sendNotificationInbox(String message) {
        kafkaTemplate.send("Notif Inbox", DigitalOpeningConstant.NOTIFICATION_INBOX);
    }

    private void sendNotificationMail(String message) {
        kafkaTemplate.send("Notif Mail", DigitalOpeningConstant.NOTIFICATION_MAIL);
    }
    private void sendNotificationFirebase(String message, boolean isExistBank) {

        // default use device id
        if (isExistBank) {
            // with cif
        }

        kafkaTemplate.send("Notif Firebase", DigitalOpeningConstant.NOTIFICATION_FIREBASE);
    }
}
