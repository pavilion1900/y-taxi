package ru.clevertec.service.impl;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;
import ru.clevertec.client.TaxiApiClient;
import ru.clevertec.entity.Coordinate;
import ru.clevertec.entity.MomentPrice;
import ru.clevertec.entity.Price;
import ru.clevertec.repository.PriceRepository;
import ru.clevertec.service.TaxiService;
import ru.clevertec.util.YandexProperties;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TaxiServiceImpl implements TaxiService {

    private final YandexProperties yandexProperties;
    private final TaxiApiClient taxiApiClient;
    private final PriceRepository priceRepository;
    private final AtomicInteger price;

    public TaxiServiceImpl(YandexProperties yandexProperties, TaxiApiClient taxiApiClient, PriceRepository priceRepository, MeterRegistry meterRegistry) {
        this.yandexProperties = yandexProperties;
        this.taxiApiClient = taxiApiClient;
        this.priceRepository = priceRepository;
        price = new AtomicInteger();
        meterRegistry.gauge("priceTaxi", price);
    }

    @Override
    public void getPrice(Coordinate startPoint, Coordinate endPoint) {
        String rll = startPoint.getLongitude() + "," + startPoint.getLatitude() + "~"
                + endPoint.getLongitude() + "," + endPoint.getLatitude();
        String clid = yandexProperties.getClid();
        String apiKey = yandexProperties.getApiKey();
        Price currentPrice = taxiApiClient.getPrice(clid, apiKey, rll);
        if (currentPrice.getOptions().isEmpty()) {
            throw new RuntimeException("Options are empty");
        }

        double priceDouble = currentPrice.getOptions().get(0).getPrice();
        price.set((int) priceDouble);
        MomentPrice momentPrice = MomentPrice.builder()
                .date(LocalDateTime.now(ZoneId.of("Asia/Yerevan")))
                .price(priceDouble)
                .build();

        priceRepository.save(momentPrice);
    }

    @Timed("gettingAllPrices")
    @Override
    public List<MomentPrice> getAllPrices() {
        return priceRepository.findAll();
    }
}
