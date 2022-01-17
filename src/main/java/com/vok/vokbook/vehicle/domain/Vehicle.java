package com.vok.vokbook.vehicle.domain;

import com.vok.vokbook.vehicle.enumerator.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Vehicle {

    private Long id;

    private String comoduleId;

    private String identifier;
// TODO fleet and model entities

//    private Fleet fleet;
//
//    private Model model;

    private BigDecimal mileage;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private String repo;

    private String ecuBranch;

    private String ecuCommit;

    private String csCommit;

}
