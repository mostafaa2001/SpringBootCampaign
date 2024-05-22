package com.ScalableCampaign.CampaignIndiegogo.dto;

import com.ScalableCampaign.CampaignIndiegogo.entity.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.CassandraType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class PrelaunchRequest {
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
