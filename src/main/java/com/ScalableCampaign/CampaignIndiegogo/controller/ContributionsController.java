package com.ScalableCampaign.CampaignIndiegogo.controller;

import com.ScalableCampaign.CampaignIndiegogo.dto.ContributionsRequest;
import com.ScalableCampaign.CampaignIndiegogo.dto.ContributionsResponse;
import com.ScalableCampaign.CampaignIndiegogo.service.contributionsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/api/contributions")
@RequiredArgsConstructor

public class ContributionsController {
    private final contributionsService contservice;

    @PostMapping("/{campaign_ID}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createContrib(@RequestBody ContributionsRequest contributionsRequest, @PathVariable("campaign_ID") UUID campaign_ID){

        return contservice.createContributions(contributionsRequest, campaign_ID);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ContributionsResponse> getAllContrib() {
        return contservice.getAllContrib();
    }
}

