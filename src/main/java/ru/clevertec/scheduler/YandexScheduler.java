package ru.clevertec.scheduler;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.clevertec.entity.Coordinate;
import ru.clevertec.service.TaxiService;
import ru.clevertec.util.CoordinateProperties;

@RequiredArgsConstructor
@Component
public class YandexScheduler {

    private final CoordinateProperties coordinateProperties;
    private final TaxiService taxiService;

    @Timed("schedulerTaxi")
    @Scheduled(fixedDelay = 30_000)
    public void updatePrice() {
        Coordinate startPoint =
                new Coordinate(coordinateProperties.getStartLongitude(), coordinateProperties.getStartLatitude());
        Coordinate endPoint =
                new Coordinate(coordinateProperties.getFinishLongitude(), coordinateProperties.getFinishLatitude());
        taxiService.getPrice(startPoint, endPoint);
    }
}
