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
public class Contributions {

    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private  UUID id;
    private UUID campaign_ID;
    private double amount;

    public Contributions(UUID id,UUID campaign_ID, double amount) {
        this.id=id;
        this.campaign_ID = campaign_ID;
        this.amount = amount;
    }

    public Contributions() {
    }

    public UUID getCampaign_ID() {
        return campaign_ID;
    }

    public double getAmount() {
        return amount;
    }

    public void setCampaign_ID(UUID campaign_ID) {
        this.campaign_ID = campaign_ID;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
