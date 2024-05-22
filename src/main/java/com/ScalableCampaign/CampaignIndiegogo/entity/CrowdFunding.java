package com.ScalableCampaign.CampaignIndiegogo.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;


import java.util.UUID;
@Data
@Builder
@Table

public class CrowdFunding {
    private UUID creator_ID;
    @PrimaryKey
    private UUID campaign_id;
    private String title;
    private String description;
    private String category;
    private String imageurl;
    private String videourl;
    private String project_timing; // launching soon, ending soon, just launched
    private String product_stage;

    private boolean isFlexible;
    private double goal;
    private double percentofgoal;

    private double amount_raised;
    public CrowdFunding(UUID creator_ID, UUID campaign_id, String title, String description, String category, String imageurl, String videourl, String project_timing, String product_stage, boolean isFlexible, double goal, double percentofgoal, double amount_raised) {
        this.creator_ID = creator_ID;
        this.campaign_id = campaign_id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.imageurl = imageurl;
        this.videourl = videourl;
        this.project_timing = project_timing;
        this.product_stage = product_stage;
        this.isFlexible = isFlexible;
        this.goal = goal;
        this.percentofgoal = percentofgoal;
        this.amount_raised = amount_raised;
    }

    public void setCreator_ID(UUID creator_ID) {
        this.creator_ID = creator_ID;
    }

    public void setCampaign_id(UUID campaign_id) {
        this.campaign_id = campaign_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public void setProject_timing(String project_timing) {
        this.project_timing = project_timing;
    }

    public void setProduct_stage(String product_stage) {
        this.product_stage = product_stage;
    }

    public void setFlexible(boolean flexible) {
        isFlexible = flexible;
    }

    public void setGoal(double goal) {
        this.goal = goal;
    }

    public void setPercentofgoal(double percentofgoal) {
        this.percentofgoal = percentofgoal;
    }

    public void setAmount_raised(double amount_raised) {
        this.amount_raised = amount_raised;
    }

    public UUID getCreator_ID() {
        return creator_ID;
    }

    public UUID getCampaign_id() {
        return campaign_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getVideourl() {
        return videourl;
    }

    public String getProject_timing() {
        return project_timing;
    }

    public String getProduct_stage() {
        return product_stage;
    }

    public boolean isFlexible() {
        return isFlexible;
    }

    public double getGoal() {
        return goal;
    }

    public double getPercentofgoal() {
        return percentofgoal;
    }

    public double getAmount_raised() {
        return amount_raised;
    }
}
