package ru.clevertec.service;

import ru.clevertec.entity.Coordinate;
import ru.clevertec.entity.MomentPrice;

import java.util.List;

public interface TaxiService {

    void getPrice(Coordinate startPoint, Coordinate endPoint);

    List<MomentPrice> getAllPrices();
}
