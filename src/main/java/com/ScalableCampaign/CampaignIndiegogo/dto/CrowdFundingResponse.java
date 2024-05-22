package com.ScalableCampaign.CampaignIndiegogo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class CrowdFundingResponse {
    private UUID creator_ID;

    private UUID campaign_id;
    private String title;
    private String description;
    private String Category;
    private String imageurl;
    private String videourl;
    private String project_timing; // launching soon, ending soon, just launched
    private String product_stage;

    private boolean isFlexible;
    private double goal;
    private double percentofgoal;

    private double amount_raised;
}
