package com.ScalableCampaign.CampaignIndiegogo.repo;
import com.ScalableCampaign.CampaignIndiegogo.entity.Prelaunch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PrelaunchCampaignRepository extends CrudRepository<Prelaunch, UUID> {

}
