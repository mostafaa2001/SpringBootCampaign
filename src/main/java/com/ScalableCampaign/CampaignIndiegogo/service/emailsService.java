package com.ScalableCampaign.CampaignIndiegogo.service;


import com.ScalableCampaign.CampaignIndiegogo.dto.ContributionsRequest;
import com.ScalableCampaign.CampaignIndiegogo.dto.ContributionsResponse;
import com.ScalableCampaign.CampaignIndiegogo.dto.EmailsRequest;
import com.ScalableCampaign.CampaignIndiegogo.dto.EmailsResponse;
import com.ScalableCampaign.CampaignIndiegogo.entity.Contributions;
import com.ScalableCampaign.CampaignIndiegogo.entity.Emails;
import com.ScalableCampaign.CampaignIndiegogo.repo.EmailsRepository;
import com.ScalableCampaign.CampaignIndiegogo.repo.PrelaunchCampaignRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class emailsService {
    private final EmailsRepository emailsRepository;
    private final PrelaunchCampaignRepository prelaunchCampaignRepository;
    public ResponseEntity<String> createEmails(EmailsRequest emailsRequest, UUID campaign_ID){

        if(!prelaunchCampaignRepository.findById(campaign_ID).isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot find prelaunch campaign");
        }

        Emails emails = Emails.builder()
                .campaign_ID(campaign_ID)
                .email(emailsRequest.getEmail())
                .build();
        emailsRepository.save(emails);

        return ResponseEntity.status(HttpStatus.CREATED).body("Email added successfully");

    }

    public List<EmailsResponse> getallemails() {
        List<Emails> emailsList = emailsRepository.findAll();

        return emailsList.stream().map(this::mapToEmails).toList();
    }

    private EmailsResponse mapToEmails(Emails Emails){
        return EmailsResponse.builder()
                .campaign_ID(Emails.getCampaign_ID())
                .email(Emails.getEmail())
                .build();
    }
}
