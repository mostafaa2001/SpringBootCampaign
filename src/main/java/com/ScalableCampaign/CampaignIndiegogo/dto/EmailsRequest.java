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
public class EmailsRequest {

    private UUID campaign_ID;
    private String email;
}
