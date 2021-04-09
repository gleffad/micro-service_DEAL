package com.api.deal.service;
import com.api.deal.Devise;
import com.api.deal.Status;
import com.api.deal.Zone;
import com.api.deal.dto.DealDto;
import com.api.deal.model.Deal;
import com.api.deal.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DealService {
    @Autowired
    private DealRepository dealRepository;

    /**
     * Renvois tous les deals présent en base de donnée
     * @return List<DealDto>
     */
    public List<DealDto> findAllDeals() {
        return dealRepository
                .findAll()
                .stream()
                .map(t -> t.toDealstDto())
                .collect(toList());
    }

    /**
     * Renvois le deal correspondant au code fonctionnel via la base de donnée
     * @param code
     * @return DealDto
     */
    public DealDto findDealByCode(String code) {
        return dealRepository
                .findByCode(code)
                .stream()
                .map(t -> t.toDealstDto())
                .collect(toList())
                .get(0);
    }

    /**
     * Clos un deal en base de donnée et le renvois
     * @param code
     * @return DealDto
     */
    public DealDto closedStatusByCode(String code) {
        Deal deal = dealRepository.findByCode(code)
                .stream()
                .collect(toList())
                .get(0);

        deal.setStatus(Status.CLOSING);
        dealRepository.save(deal);

        return deal.toDealstDto();
    }
}
