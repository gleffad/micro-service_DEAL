package com.api.deal.model;

import com.api.deal.Devise;
import com.api.deal.Status;
import com.api.deal.Zone;
import com.api.deal.dto.DealDto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private Float amount;
    private Zone zone;
    private Devise devise;
    private String borrower;
    private String lender;
    private Status status;

    @Tolerate
    public Deal() {}

    @Tolerate
    public Deal(String code, String name, Float amount, Zone zone, Devise devise, String borrower, String lender, Status status) {
        this.code = code;
        this.name = name;
        this.amount = amount;
        this.zone = zone;
        this.devise = devise;
        this.borrower = borrower;
        this.lender = lender;
        this.status = status;
    }

    public DealDto toDealstDto() {
        return  DealDto.builder()
                .code(this.code)
                .name(this.name)
                .amount(this.amount)
                .zone(this.zone)
                .devise(this.devise)
                .borrower(this.borrower)
                .lender(this.lender)
                .status(this.status)
                .build();
    }
}