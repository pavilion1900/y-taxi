package ru.clevertec.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.entity.MomentPrice;
import ru.clevertec.service.TaxiService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prices")
public class PriceController {

    private final TaxiService taxiService;

    @GetMapping
    public List<MomentPrice> getAllPrices() {
        return taxiService.getAllPrices();
    }
}
