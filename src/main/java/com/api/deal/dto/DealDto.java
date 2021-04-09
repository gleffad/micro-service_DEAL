package com.api.deal.dto;

import com.api.deal.Devise;
import com.api.deal.Status;
import com.api.deal.Zone;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class DealDto {
    private String code;
    private String name;
    private Float amount;
    private Zone zone;
    private Devise devise;
    private String borrower;
    private String lender;
    private Status status;
}

