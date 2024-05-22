package com.ScalableCampaign.CampaignIndiegogo.service;

import com.ScalableCampaign.CampaignIndiegogo.dto.*;
import com.ScalableCampaign.CampaignIndiegogo.entity.Contributions;
import com.ScalableCampaign.CampaignIndiegogo.entity.CrowdFunding;
import com.ScalableCampaign.CampaignIndiegogo.repo.ContributionsRepository;
import com.ScalableCampaign.CampaignIndiegogo.repo.CrowdfundingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class contributionsService {
    private final ContributionsRepository ContributionsRepository;
    private final CrowdfundingRepository crowdfundingRepository;
    private final crowdfundingService cr;

    public ResponseEntity<String> createContributions(ContributionsRequest contributionsRequest, UUID campaign_ID){
        if(!crowdfundingRepository.findById(campaign_ID).isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot find crowdfunding campaign");
        }
        else if(contributionsRequest.getAmount() <= 0.0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please enter a value greater than zero");
        }
        Contributions contributions = Contributions.builder()
                .id(UUID.randomUUID())
                .campaign_ID(campaign_ID)
                .amount(contributionsRequest.getAmount())
                .build();

        ContributionsRepository.save(contributions);
        Optional<CrowdFunding> p = crowdfundingRepository.findById(campaign_ID);
        CrowdFunding pp = p.get();
        log.info("LLLLLLLLLLLLLLLL jm PreLaunch Campaign {} is saved",contributionsRequest.getCampaign_ID());
        pp.setAmount_raised(pp.getAmount_raised()+contributionsRequest.getAmount());
        double amount  =pp.getAmount_raised();
        double goal =  pp.getGoal();
        double result = (amount/goal)*100;



        pp.setPercentofgoal(result);
        crowdfundingRepository.save(pp);

        if(!pp.isFlexible() && result >= 100.0){
            crowdfundingRepository.deleteById(campaign_ID);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Contributions delivered successfully");
    }

    public List<ContributionsResponse> getAllContrib() {
        List<Contributions> contributionsList = ContributionsRepository.findAll();

        return contributionsList.stream().map(this::mapToContributions).toList();
    }

    private ContributionsResponse mapToContributions(Contributions contributions){
        return ContributionsResponse.builder()
                .campaign_ID(contributions.getCampaign_ID())
                .amount(contributions.getAmount())
                .build();
    }


}
