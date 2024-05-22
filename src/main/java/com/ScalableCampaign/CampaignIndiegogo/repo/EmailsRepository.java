package com.ScalableCampaign.CampaignIndiegogo.repo;


import com.ScalableCampaign.CampaignIndiegogo.entity.Emails;
import org.springframework.data.cassandra.repository.MapIdCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailsRepository extends MapIdCassandraRepository<Emails> {
}
