package id.co.diansetiyadi.digitalopeningservice.service.impl;

import com.google.gson.Gson;
import id.co.diansetiyadi.digitalopeningservice.dto.request.InquiryDigitalOpeningApplyRequest;
import id.co.diansetiyadi.digitalopeningservice.dto.request.SubmitApplyOpeningRequest;
import id.co.diansetiyadi.digitalopeningservice.dto.request.ValidationApplyOpeningRequest;
import id.co.diansetiyadi.digitalopeningservice.dto.response.InquiryDigitalOpeningApplyResponse;
import id.co.diansetiyadi.digitalopeningservice.dto.response.SubmitApplyOpeningResponse;
import id.co.diansetiyadi.digitalopeningservice.dto.response.ValidationApplyOpeningResponse;
import id.co.diansetiyadi.digitalopeningservice.entity.DigitalOpeningApply;
import id.co.diansetiyadi.digitalopeningservice.repository.DigitalOpeningApplyRepository;
import id.co.diansetiyadi.digitalopeningservice.service.DigitalOpeningService;
import id.co.diansetiyadi.digitalopeningservice.util.DigitalOpeningConstant;
import id.co.diansetiyadi.digitalopeningservice.util.DigitalOpeningHelper;
import id.co.diansetiyadi.digitalopeningservice.util.StatusApplyEnum;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DigitalOpeningServiceImpl implements DigitalOpeningService {
    private static final Logger logger = LoggerFactory.getLogger(DigitalOpeningServiceImpl.class);
    private final Gson gson;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final DigitalOpeningApplyRepository digitalOpeningApplyRepository;

    @Autowired
    public DigitalOpeningServiceImpl(Gson gson, KafkaTemplate<String, String> kafkaTemplate, DigitalOpeningApplyRepository digitalOpeningApplyRepository) {
        this.gson = gson;
        this.kafkaTemplate = kafkaTemplate;
        this.digitalOpeningApplyRepository = digitalOpeningApplyRepository;
    }

    @Override
    public void sendNotification() {

    }

    @Override
    public SubmitApplyOpeningResponse submitApplication(SubmitApplyOpeningRequest request) {

        DigitalOpeningApply digitalOpeningApply = new DigitalOpeningApply();
        digitalOpeningApply.setDataApply(gson.toJson(request));
        digitalOpeningApply.setCif(request.getCif());
        digitalOpeningApply.setReffCode(DigitalOpeningHelper.generateReffCode(request.getCif()));
        digitalOpeningApply.setListProductApply(gson.toJson(request.getProductList()));
        digitalOpeningApply.setStatus(StatusApplyEnum.INPROGRESS);

        digitalOpeningApplyRepository.save(digitalOpeningApply);
        sendNotificationInbox("Send Notification");
        sendNotificationMail("Send Notification");
        sendNotificationFirebase("Send Notification", request.getIsExistBank() );
        return SubmitApplyOpeningResponse.builder()
                .reffCode(digitalOpeningApply.getReffCode())
                .build();
    }

    @Override
    public ValidationApplyOpeningResponse validationApply(ValidationApplyOpeningRequest request) {
        logger.info("Validation Apply");
        return null;
    }

    @Override
    public List<InquiryDigitalOpeningApplyResponse> inquiryDigitalOpeningApply(InquiryDigitalOpeningApplyRequest request) {
        List<DigitalOpeningApply> digitalOpeningApplyList = digitalOpeningApplyRepository.findByDeviceId(request.getDeviceId());
        List<InquiryDigitalOpeningApplyResponse> inquiryDigitalOpeningApplyResponses = new ArrayList<>();
        for (DigitalOpeningApply doa: digitalOpeningApplyList) {
            inquiryDigitalOpeningApplyResponses.add(InquiryDigitalOpeningApplyResponse.builder()
                            .cif(doa.getCif())
                            .listProduct(doa.getListProductApply())
                            .statusApply(doa.getStatus())
                            .reffCode(doa.getReffCode())
                    .build());
        }

        return inquiryDigitalOpeningApplyResponses;
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
