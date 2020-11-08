package com.hipravin.samples.codesamples.dao.jpacodesamples2;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "MEETINGS")
public class MeetingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mtgSeq")
    @SequenceGenerator(sequenceName = "MTG_ID_SEQ", allocationSize = 100, name = "mtgSeq")
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "START_TIME")
    private OffsetDateTime startTime;

    @Column(name = "END_TIME")
    private OffsetDateTime endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
    }
}
