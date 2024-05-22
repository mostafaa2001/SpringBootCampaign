package com.ScalableCampaign.CampaignIndiegogo.service;

import com.ScalableCampaign.CampaignIndiegogo.dto.PrelaunchRequest;
import com.ScalableCampaign.CampaignIndiegogo.dto.PrelaunchResponse;
import com.ScalableCampaign.CampaignIndiegogo.entity.CrowdFunding;
import com.ScalableCampaign.CampaignIndiegogo.entity.Prelaunch;
import com.ScalableCampaign.CampaignIndiegogo.repo.PrelaunchCampaignRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.mapping.MapId;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.lang.Thread.sleep;


@Service
@RequiredArgsConstructor
@Slf4j
public class prelaunchService {
    @Autowired
    private MyService myService; // Inject MyService here
    private final PrelaunchCampaignRepository prelaunchCampaignRepository;


    public ResponseEntity<String> createPrelauch(PrelaunchRequest prelaunchrequest, UUID creator_id) {
        UUID campaign_id_new = UUID.randomUUID();
        Prelaunch prelaunch = Prelaunch.builder()
                .creator_ID(creator_id)
                .campaign_id(campaign_id_new)
                .title(prelaunchrequest.getTitle())
                .Category(prelaunchrequest.getCategory())
                .project_timing(prelaunchrequest.getProject_timing())
                .product_stage(prelaunchrequest.getProduct_stage())
                .description(prelaunchrequest.getDescription())
                .imageurl(prelaunchrequest.getImageurl())
                .videourl(prelaunchrequest.getVideourl())
                .build();

        if(prelaunchrequest.getTitle() == null|| prelaunchrequest.getCategory() == null|| prelaunchrequest.getDescription() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please provide values for title, description, and category");
        }

        prelaunchCampaignRepository.save(prelaunch);
        UUID key = campaign_id_new;
        UUID value = creator_id;

        myService.setValue(STR."\{key}PRE", String.valueOf(value));

        return ResponseEntity.status(HttpStatus.CREATED).body("prelaunch campaign saved successfully");
    }

    public List<PrelaunchResponse> getAllPrelaunch()  {

        List<Prelaunch> prelaunches = (List<Prelaunch>) prelaunchCampaignRepository.findAll();
        List<PrelaunchResponse> listprelaunch = prelaunches.stream().map(this::mapToPrelaunchresponse).toList();



        return listprelaunch;
    }

    private PrelaunchResponse mapToPrelaunchresponse(Prelaunch prelaunch) {
        return PrelaunchResponse.builder()
                .creator_ID(prelaunch.getCreator_ID())
                .campaign_id(prelaunch.getCampaign_id())
                .title(prelaunch.getTitle())
                .Category(prelaunch.getCategory())
                .project_timing(prelaunch.getProject_timing())
                .product_stage(prelaunch.getProduct_stage())

                .description(prelaunch.getDescription())
                .imageurl(prelaunch.getImageurl())
                .videourl(prelaunch.getVideourl())
                .build();

    }


    public ResponseEntity<String> deletePrelaunchByCampaignId(UUID campaign_id, UUID creator_id) {

        if(!prelaunchCampaignRepository.findById(campaign_id).isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't find campaign !");
        }

        else if(prelaunchCampaignRepository.findById(campaign_id).get().getCreator_ID().equals(creator_id)) {
            prelaunchCampaignRepository.deleteById(campaign_id);
            UUID key = campaign_id;
            UUID value = creator_id;

            myService.removeValue(STR."\{key}PRE");

            return ResponseEntity.status(HttpStatus.CREATED).body("prelaunch campaign deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unauthorized to delete !");
    }

    public ResponseEntity<String> updateprelaunchbyid(UUID campaignId, Prelaunch pnew, UUID creator_id) {
        Optional<Prelaunch> p = prelaunchCampaignRepository.findById(campaignId);

        if (p.isPresent() && prelaunchCampaignRepository.findById(campaignId).get().getCreator_ID().equals(creator_id)) {
            Prelaunch pold = p.get();


            /*if (pnew.getCreator_ID() != null) {
                pold.setCreator_ID(pnew.getCreator_ID());
            }
            if (pnew.getCampaign_id() != null) {
                pold.setCampaign_id(pnew.getCampaign_id());
            }*/
            if (pnew.getTitle() != null) {
                pold.setTitle(pnew.getTitle());
            }
            if (pnew.getCategory() != null) {
                pold.setCategory(pnew.getCategory());
            }
            if (pnew.getProject_timing() != null) {

                pold.setProject_timing(pnew.getProject_timing());

            }
            if (pnew.getProduct_stage() != null) {
                pold.setProduct_stage(pnew.getProduct_stage());
            }

            if (pnew.getDescription() != null) {
                pold.setDescription(pnew.getDescription());
            }
            if (pnew.getImageurl() != null) {
                pold.setImageurl(pnew.getImageurl());
            }
            if (pnew.getVideourl() != null) {
                pold.setVideourl(pnew.getVideourl());
            }
            prelaunchCampaignRepository.save(pold);
            UUID key = campaignId;
            UUID value = creator_id;

            myService.setValue(STR."\{key}PRE", String.valueOf(value));

            return ResponseEntity.status(HttpStatus.CREATED).body("prelaunch campaign Updated successfully");
        }
        else if(!prelaunchCampaignRepository.findById(campaignId).isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't find campaign !");
        }
        else {
            return ResponseEntity.status(HttpStatus.CREATED).body("unauthorized to update");
        }

    }

}
