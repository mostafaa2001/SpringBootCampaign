package com.ScalableCampaign.CampaignIndiegogo.controller;

import com.ScalableCampaign.CampaignIndiegogo.dto.PrelaunchRequest;
import com.ScalableCampaign.CampaignIndiegogo.dto.PrelaunchResponse;
//import com.ScalableCampaign.CampaignIndiegogo.entity.CrowdFunding;
import com.ScalableCampaign.CampaignIndiegogo.entity.Prelaunch;
import com.ScalableCampaign.CampaignIndiegogo.service.prelaunchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/api/prelaunch")
@RequiredArgsConstructor
public class PrelaunchCampaignController {

    private final prelaunchService preservice;
    @PostMapping("/{creator_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createPrelauch(@RequestBody PrelaunchRequest prelaunchRequest
            , @PathVariable("creator_id")UUID creator_id){

    return preservice.createPrelauch(prelaunchRequest, creator_id);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PrelaunchResponse> getAllPrelaunch() {
        return preservice.getAllPrelaunch();
    }

    @DeleteMapping("/{creator_id}/{campaign_id}")
    public ResponseEntity<String> deletePrelaunch(@PathVariable("campaign_id")UUID campaign_id
    , @PathVariable("creator_id") UUID userid) {
        return preservice.deletePrelaunchByCampaignId(campaign_id, userid);
    }

    @PatchMapping("/{creator_id}/{campaign_id}")
        public ResponseEntity<String> updateprelaunch(@PathVariable("campaign_id")UUID campaign_id, @RequestBody Prelaunch pr,
                                    @PathVariable("creator_id") UUID creator_id) {
        return preservice.updateprelaunchbyid(campaign_id , pr, creator_id);
    }

}
