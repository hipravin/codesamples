package com.hipravin.samples.codesamples.dao.jpacodesamples1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(transactionManager = "codesamples1TransactionManager")
public interface MeetingRepository extends JpaRepository<MeetingEntity, Long>, CustomMeetingRepository {
}
