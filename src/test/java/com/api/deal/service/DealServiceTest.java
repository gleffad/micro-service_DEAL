package com.api.deal.service;
import java.util.ArrayList;
import java.util.List;
import com.api.deal.Status;
import com.api.deal.dto.DealDto;
import com.api.deal.model.Deal;
import com.api.deal.repository.DealRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DealServiceTest {

	@Mock
	private DealRepository dealRepository;

	@InjectMocks
	private DealService dealService;
	

	@Test
	public void findAllDeals() {
		// given
		Deal deal0  = Deal.builder().code("L120938").build();
		Deal deal1  = Deal.builder().code("L120939").build();
		Mockito.when(dealRepository.findAll()).thenReturn(List.of(deal0, deal1));

		// when
		List<DealDto> result = dealService.findAllDeals();

		// then
		DealDto dealDto0  = DealDto.builder().code("L120938").build();
		DealDto dealDto1  = DealDto.builder().code("L120939").build();
		List<DealDto> expectedDeal = new ArrayList<DealDto>();
		expectedDeal.add(dealDto0);
		expectedDeal.add(dealDto1);
		Assertions.assertThat(result).isEqualTo(expectedDeal);
	}

	@Test
	public void findDealByCode() {
		// given
		String dealCode = "D1234";
		Deal deal  = Deal.builder().code(dealCode).build();
		Mockito.when(dealRepository.findByCode(dealCode)).thenReturn(List.of(deal));

		// when
		DealDto result = dealService.findDealByCode(dealCode);

		// then
		DealDto expectedDeal =  DealDto.builder().code(dealCode).build();
		Assertions.assertThat(result).isEqualTo(expectedDeal);

	}

	@Test
	public void closedStatusByCode() {
		//given
		String dealCode = "L234930";
		Deal deal = Deal.builder()
				.code(dealCode)
				.status(Status.PUSHED)
				.build();
		Mockito.when(dealRepository.findByCode(dealCode)).thenReturn(List.of(deal));

		//when
		DealDto result = dealService.closedStatusByCode(dealCode);

		//then
		DealDto expectedDeal = DealDto.builder()
				.code(dealCode)
				.status(Status.CLOSING)
				.build();
		Assertions.assertThat(result).isEqualTo(expectedDeal);
	}
}
