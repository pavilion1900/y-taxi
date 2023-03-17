package ru.clevertec.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Price {

    public List<Option> options;

    public String currency;

    public double distance;

    @JsonProperty(value = "time_text")
    public String timeText;
}
