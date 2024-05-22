package com.ScalableCampaign.CampaignIndiegogo;

import com.ScalableCampaign.CampaignIndiegogo.entity.Prelaunch;
import com.ScalableCampaign.CampaignIndiegogo.repo.ContributionsRepository;
import com.ScalableCampaign.CampaignIndiegogo.repo.CrowdfundingRepository;
import com.ScalableCampaign.CampaignIndiegogo.repo.PrelaunchCampaignRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;



import java.time.LocalDateTime;
import java.util.*;


@SpringBootApplication
@EnableCassandraRepositories(basePackages = "com.ScalableCampaign.CampaignIndiegogo.repo")
@EntityScan("com.ScalableCampaign.CampaignIndiegogo.entity")
//@ComponentScan
public class PrelaunchApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrelaunchApplication.class, args);
	}

//	@Bean
//	public ApplicationRunner applicationRunner(PrelaunchCampaignRepository prelaunchCampaignRepository, CrowdfundingRepository crowdfundingRepository, ContributionsRepository contributionsRepository) {
//		return args -> {
//
//
//
//			UUID creatorId = UUID.randomUUID();
//			UUID campaignId = UUID.randomUUID();
//
//			// Sample data for a prelaunch entry
//			String title = "My Campaign";
//			String category = "Technology";
//			String projectTiming = "launching soon";
//			String productStage = "Prototype";
//
//			String description = "This is a description of the campaign.";
//			String imageUrl = "https://example.com/image.jpg";
//			String videoUrl = "https://example.com/video.mp4";
//
//			// Create a Prelaunch object with the provided data
//			Prelaunch prelaunch = new Prelaunch(creatorId, campaignId, title, category, projectTiming, productStage ,description, imageUrl, videoUrl);
//
//			// Print the created Prelaunch object
//			System.out.println("Prelaunch Entry:");
//			System.out.println("Creator ID: " + prelaunch.getCreator_ID());
//			System.out.println("Campaign ID: " + prelaunch.getCampaign_id());
//			System.out.println("Title: " + prelaunch.getTitle());
//			System.out.println("Category: " + prelaunch.getCategory());
//			System.out.println("Project Timing: " + prelaunch.getProject_timing());
//			System.out.println("Product Stage: " + prelaunch.getProduct_stage());
//
//			System.out.println("Description: " + prelaunch.getDescription());
//			System.out.println("Image URL: " + prelaunch.getImageurl());
//			System.out.println("Video URL: " + prelaunch.getVideourl());
//
//			// Save the Prelaunch object using your data access layer
//			 prelaunchCampaignRepository.save(prelaunch);
//
//			 prelaunchCampaignRepository.findById(campaignId).ifPresent(
//					v -> prelaunchCampaignRepository.delete(v)
//			);
//
////			crowdfundingRepository.deleteAll();
//		};
//	}
}
