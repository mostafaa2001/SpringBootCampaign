package com.ScalableCampaign.CampaignIndiegogo.controller;


import com.ScalableCampaign.CampaignIndiegogo.dto.CrowdFundingRequest;
import com.ScalableCampaign.CampaignIndiegogo.dto.CrowdFundingResponse;
import com.ScalableCampaign.CampaignIndiegogo.entity.CrowdFunding;
//import com.ScalableCampaign.CampaignIndiegogo.service.MyService;
import com.ScalableCampaign.CampaignIndiegogo.service.crowdfundingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
@Slf4j
@RequestMapping("/api/crowdfunding")
@RequiredArgsConstructor
public class CrowdFundingCampaignController {


    private final crowdfundingService crservice;
    @PostMapping("/{creator_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createCrowd(@RequestBody CrowdFundingRequest crowdFundingRequest
            , @PathVariable("creator_id")UUID creator_id){
        return crservice.createCrowdfunding(crowdFundingRequest , creator_id);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CrowdFundingResponse> getAllCrowd() {
        return crservice.getAllCrowd();
    }


    @DeleteMapping("/{userid}/{campaign_id}")
    public ResponseEntity<String> deletecrowd(@PathVariable("campaign_id") UUID campaign_id,
                                              @PathVariable("userid") UUID userid) {
        return crservice.deletecrowdbyid(campaign_id, userid);
    }
    @PatchMapping("/{userid}/{campaign_id}")
    public ResponseEntity<String> updatecrowd(@PathVariable("campaign_id")UUID campaign_id,
                                              @PathVariable("userid") UUID userid, @RequestBody CrowdFunding cr) {
        return crservice.updatecrowdbyid(campaign_id , userid, cr);
    }



}
