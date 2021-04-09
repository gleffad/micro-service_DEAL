package com.api.deal.component;

import com.api.deal.Devise;
import com.api.deal.Status;
import com.api.deal.Zone;
import com.api.deal.model.Deal;
import com.api.deal.repository.DealRepository;
import com.api.deal.service.DealService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DealInitListener {

    private DealService dealService;

    @RabbitListener(queues = "${deal-init.rabbitmq.queue}")
    public void handleContextStart(Deal payload) {
        System.out.println(payload.toString());

    }
}

