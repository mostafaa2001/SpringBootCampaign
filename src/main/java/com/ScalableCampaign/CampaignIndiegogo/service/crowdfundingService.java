package com.ScalableCampaign.CampaignIndiegogo.service;

import com.ScalableCampaign.CampaignIndiegogo.dto.CrowdFundingRequest;
import com.ScalableCampaign.CampaignIndiegogo.dto.CrowdFundingResponse;
import com.ScalableCampaign.CampaignIndiegogo.entity.CrowdFunding;
import com.ScalableCampaign.CampaignIndiegogo.repo.CrowdfundingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.lang.StringTemplate.STR;


@Service
@RequiredArgsConstructor
@Slf4j

public class crowdfundingService {
    @Autowired
    private MyService myService; // Inject MyService here
    private final CrowdfundingRepository CrowdfundingRepository;



    public ResponseEntity<String> createCrowdfunding(CrowdFundingRequest crowdFundingRequest, UUID creator_id){
        UUID campaign_id_new = UUID.randomUUID();
        CrowdFunding crowdFunding = CrowdFunding.builder()
                .creator_ID(creator_id)
                .campaign_id(campaign_id_new)
                .title(crowdFundingRequest.getTitle())
                .description(crowdFundingRequest.getDescription())
                .category(crowdFundingRequest.getCategory())
                .imageurl(crowdFundingRequest.getImageurl())
                .videourl(crowdFundingRequest.getVideourl())
                .project_timing(crowdFundingRequest.getProject_timing())
                .product_stage(crowdFundingRequest.getProduct_stage())
                .isFlexible(crowdFundingRequest.isFlexible())
                .goal(crowdFundingRequest.getGoal())
                .percentofgoal(0.0)
                .amount_raised(0.0)
                .build();


        if (crowdFundingRequest.getTitle() == null || crowdFundingRequest.getDescription() == null || crowdFundingRequest.getGoal() == 0.0 ||
        crowdFundingRequest.getCategory() == null ) {
            // Return error response if required fields are missing
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please provide values for title, description, category,and goal");
        }




        CrowdfundingRepository.save(crowdFunding);
        UUID key = campaign_id_new;
        UUID value = creator_id;

        myService.setValue(STR."\{key}CRF", String.valueOf(value));





        return ResponseEntity.status(HttpStatus.CREATED).body("Crowdfunding entity saved successfully");
    }

    public List<CrowdFundingResponse> getAllCrowd() {
        List<CrowdFunding> crowdFundings = (List<CrowdFunding>) CrowdfundingRepository.findAll();





        return crowdFundings.stream().map(this::mapToCrowdResponse).toList();
    }

    private CrowdFundingResponse mapToCrowdResponse(CrowdFunding crowdFunding){
        return CrowdFundingResponse.builder()
                .creator_ID(crowdFunding.getCreator_ID())
                .campaign_id(crowdFunding.getCampaign_id())
                .title(crowdFunding.getTitle())
                .Category(crowdFunding.getCategory())
                .project_timing(crowdFunding.getProject_timing())
                .product_stage(crowdFunding.getProduct_stage())
                .description(crowdFunding.getDescription())
                .imageurl(crowdFunding.getImageurl())
                .videourl(crowdFunding.getVideourl())
                .isFlexible(crowdFunding.isFlexible())
                .goal(crowdFunding.getGoal())
                .percentofgoal(crowdFunding.getPercentofgoal())
                .amount_raised(crowdFunding.getAmount_raised())
                .build();

    }


    public ResponseEntity<String> deletecrowdbyid(UUID campaignId, UUID creator_id) {

         if(!CrowdfundingRepository.findById(campaignId).isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't find campaign !");
        }
        if(CrowdfundingRepository.findById(campaignId).get().getCreator_ID().equals(creator_id)){
            CrowdfundingRepository.deleteById(campaignId);
            UUID key = campaignId;

            myService.removeValue(STR."\{key}CRF");

            return ResponseEntity.status(HttpStatus.CREATED).body("Crowdfunding campaign deleted successfully");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unauthorized to delete !");
    }
    public ResponseEntity<String> updatecrowdbyid(UUID campaignId, UUID creator_id,CrowdFunding pnew) {


        Optional<CrowdFunding> p = CrowdfundingRepository.findById(campaignId);

        if (p.isPresent() && CrowdfundingRepository.findById(campaignId).get().getCreator_ID().equals(creator_id) ) {
            CrowdFunding cold = p.get();


            /*if (pnew.getCreator_ID() != null) {
                pold.setCreator_ID(pnew.getCreator_ID());
            }
            if (pnew.getCampaign_id() != null) {
                pold.setCampaign_id(pnew.getCampaign_id());
            }*/
            if (pnew.getTitle() != null) {
                cold.setTitle(pnew.getTitle());
            }
            if (pnew.getCategory() != null) {
                cold.setCategory(pnew.getCategory());
            }
            if (pnew.getProject_timing() != null) {

                cold.setProject_timing(pnew.getProject_timing());

            }
            if (pnew.getProduct_stage() != null) {
                cold.setProduct_stage(pnew.getProduct_stage());
            }


            if (pnew.getDescription() != null) {
                cold.setDescription(pnew.getDescription());
            }
            if (pnew.getImageurl() != null) {
                cold.setImageurl(pnew.getImageurl());
            }
            if (pnew.getVideourl() != null) {
                cold.setVideourl(pnew.getVideourl());
            }
            CrowdfundingRepository.save(cold);
            UUID key = campaignId;
            UUID value = creator_id;

            myService.setValue(STR."\{key}CRF", String.valueOf(value));

            return ResponseEntity.status(HttpStatus.CREATED).body("Crowdfunding campaign Updated successfully");

        }
        else if(!CrowdfundingRepository.findById(campaignId).isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't find campaign !");
        }
        else {
            return ResponseEntity.status(HttpStatus.CREATED).body("unauthorized to update");
        }

    }

}
