package com.ScalableCampaign.CampaignIndiegogo.repo;
import com.ScalableCampaign.CampaignIndiegogo.entity.CrowdFunding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CrowdfundingRepository extends CrudRepository<CrowdFunding, UUID> {
}