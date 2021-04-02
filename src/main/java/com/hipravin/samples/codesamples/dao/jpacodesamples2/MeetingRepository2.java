package com.hipravin.samples.codesamples.dao.jpacodesamples2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(transactionManager = "codesamples2TransactionManager")
public interface MeetingRepository2 extends JpaRepository<MeetingEntity, Long>, CustomMeetingRepository2 {
}
