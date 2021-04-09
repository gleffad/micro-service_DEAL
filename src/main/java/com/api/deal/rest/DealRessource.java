package com.api.deal.rest;

import com.api.deal.dto.DealDto;
import com.api.deal.repository.DealRepository;
import com.api.deal.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DealRessource {
    @Autowired
    private DealService dealService;

    @Autowired
    private DealRepository dealRepository;

    /**
     * Donne accès à tous les deals suit avec la route /api/v1/deals
     * @return List<DealDto>
     */
    @GetMapping("/api/v1/deals")
    public List<DealDto> getDeals() {
        return dealService.findAllDeals();
    }

    /**
     * Donne accès à un deals via le code avec la route /api/v1/deals/{code}
     * @param code
     * @return DealDto
     */
    @GetMapping("/api/v1/deals/{code}")
    public DealDto getDeal(@PathVariable(value = "code") String code) {
        return dealService.findDealByCode(code);
    }

    /**
     * Change le status d'un deal et le renvois ave la route /api/v1/deals/close/{code}
     * @param code
     * @return DealDto
     */
    @PutMapping("/api/v1/deals/close/{code}")
    public DealDto closedStatus(@PathVariable(value = "code") String code) {
        return dealService.closedStatusByCode(code);
    }
}
