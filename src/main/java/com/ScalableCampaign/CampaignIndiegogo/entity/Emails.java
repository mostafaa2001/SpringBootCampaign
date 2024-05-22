package com.ScalableCampaign.CampaignIndiegogo.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;
@Data
@Builder
@Table
public class Emails {
    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID campaign_ID;
    private String email;

    public Emails(UUID campaign_ID, String email) {
        this.campaign_ID = campaign_ID;
        this.email = email;
    }

    public UUID getCampaign_ID() {
        return campaign_ID;
    }

    public void setCampaign_ID(UUID campaign_ID) {
        this.campaign_ID = campaign_ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
