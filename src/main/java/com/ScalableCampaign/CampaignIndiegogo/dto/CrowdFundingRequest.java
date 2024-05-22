package com.ScalableCampaign.CampaignIndiegogo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class CrowdFundingRequest {
    private UUID creator_ID;

    private UUID campaign_id;
    private String title;
    private String description;
    private String category;
    private String Imageurl;
    private String videourl;
    private String project_timing; // launching soon, ending soon, just launched
    private String product_stage;

    private boolean isFlexible;
    private double goal;
    private double percentofgoal;

    private double amount_raised;


}
