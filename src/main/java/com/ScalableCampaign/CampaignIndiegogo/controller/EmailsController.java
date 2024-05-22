package com.ScalableCampaign.CampaignIndiegogo.controller;

import com.ScalableCampaign.CampaignIndiegogo.dto.EmailsResponse;
import com.ScalableCampaign.CampaignIndiegogo.dto.EmailsRequest;
import com.ScalableCampaign.CampaignIndiegogo.service.emailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/api/emails")
@RequiredArgsConstructor
public class EmailsController {

    private final emailsService emailsService;

    @PostMapping("/{campaign_ID}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createContrib(@RequestBody EmailsRequest emailsRequest, @PathVariable("campaign_ID") UUID campaign_ID){

        return emailsService.createEmails(emailsRequest, campaign_ID);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmailsResponse> getallemails() {
        return emailsService.getallemails();
    }
}
