package com.ScalableCampaign.CampaignIndiegogo.repo;
import com.ScalableCampaign.CampaignIndiegogo.entity.Contributions;
import org.springframework.data.cassandra.repository.MapIdCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionsRepository extends MapIdCassandraRepository<Contributions> {
}
