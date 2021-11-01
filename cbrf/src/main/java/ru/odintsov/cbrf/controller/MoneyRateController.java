package ru.odintsov.cbrf.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.odintsov.cbrf.model.MoneyRate;
import ru.odintsov.cbrf.service.MoneyRateService;

@RestController
@RequestMapping
@AllArgsConstructor
public class MoneyRateController {

    public final MoneyRateService moneyRateService;

    @GetMapping("/api/v1/rate/{currency}")
    public MoneyRate getMoneyRate(@PathVariable("currency") String currency) throws Exception {

        MoneyRate rate = moneyRateService.getMoneyRate(currency);
        return rate;
    }
}
