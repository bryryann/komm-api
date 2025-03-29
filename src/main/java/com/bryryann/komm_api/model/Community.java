package com.bryryann.komm_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "communityId")
@Entity(name = "communities")
@Table(name = "communities")
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long communityId;

    private String name;

    private String slug;

    private String description;

    private BigInteger createdBy;

    private Date createdAt = Date.from(Instant.now());

    private Date updatedAt = Date.from(Instant.now());

    private boolean isPrivate = false;

    private int memberCount = 0;

}
