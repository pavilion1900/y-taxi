package ru.clevertec.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "coordinate")
@ConstructorBinding
@Getter
@RequiredArgsConstructor
public class CoordinateProperties {

    private final String startLongitude;
    private final String startLatitude;
    private final String finishLongitude;
    private final String finishLatitude;
}
