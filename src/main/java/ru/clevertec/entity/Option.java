package ru.clevertec.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Option {

    public double price;

    @JsonProperty(value = "min_price")
    public double minPrice;

    @JsonProperty(value = "waiting_time")
    public double waitingTime;

    @JsonProperty(value = "class_name")
    public String className;

    @JsonProperty(value = "price_text")
    public String priceText;
}
