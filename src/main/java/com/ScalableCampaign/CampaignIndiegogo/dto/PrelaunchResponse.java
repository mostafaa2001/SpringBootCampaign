package com.ScalableCampaign.CampaignIndiegogo.dto;


import com.ScalableCampaign.CampaignIndiegogo.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.CassandraType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrelaunchResponse {
    private UUID creator_ID;
    private UUID campaign_id;
    private String title;
    private String Category;
    private String project_timing; // launching soon, ending soon, just launched
    private String product_stage;

    private String description;
    private String imageurl;
    private String videourl;
}
