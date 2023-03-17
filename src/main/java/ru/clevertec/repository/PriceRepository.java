package ru.clevertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.entity.MomentPrice;

public interface PriceRepository extends JpaRepository<MomentPrice, Integer> {

}
