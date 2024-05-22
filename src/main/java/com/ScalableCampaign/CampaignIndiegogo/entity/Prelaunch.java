package com.ScalableCampaign.CampaignIndiegogo.entity;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@Table

//@RedisHash("Prelaunch")
public class Prelaunch {
    private UUID creator_ID;
    @PrimaryKey
    private UUID campaign_id;
    private String title;
    private String Category;
    private String project_timing; // launching soon, ending soon, just launched
    private String product_stage;

    private String description;
    private String imageurl;
    private String videourl;

    public Prelaunch() {
    }

    public Prelaunch(UUID creator_ID, UUID campaign_id, String title, String category, String project_timing, String product_stage, String description, String imageurl, String videourl) {
        this.creator_ID = creator_ID;
        this.campaign_id = campaign_id;
        this.title = title;
        Category = category;
        this.project_timing = project_timing;
        this.product_stage = product_stage;

        this.description = description;
        this.imageurl = imageurl;
        this.videourl = videourl;
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

    public String getCategory() {
        return Category;
    }

    public String getProject_timing() {
        return project_timing;
    }

    public String getProduct_stage() {
        return product_stage;
    }






    public String getDescription() {
        return description;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getVideourl() {
        return videourl;
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

    public void setCategory(String category) {
        Category = category;
    }

    public void setProject_timing(String project_timing) {
        this.project_timing = project_timing;
    }

    public void setProduct_stage(String product_stage) {
        this.product_stage = product_stage;
    }



    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    // Create a MapId object using the primary key columns

}
