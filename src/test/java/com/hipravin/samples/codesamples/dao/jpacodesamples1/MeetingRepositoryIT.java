package com.hipravin.samples.codesamples.dao.jpacodesamples1;

import com.hipravin.samples.codesamples.dao.jpacodesamples2.MeetingRepository2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MeetingRepositoryIT {
    @Autowired
    MeetingRepository meetingRepository;
    @Autowired
    MeetingRepository2 meetingRepository2;

    @Test
    void testFindAll() {


        List<MeetingEntity> meetings = meetingRepository.findAll();

        assertEquals(2, meetings.size());

        MeetingEntity me = new MeetingEntity();
        me.setDescription("Meeting 3 from test");
        me.setStartTime(OffsetDateTime.now());
        me.setEndTime(OffsetDateTime.now().plusHours(1));

        meetingRepository.save(me);

        assertEquals(3, meetingRepository.count());

        assertEquals(2, meetingRepository2.count());


    }
}