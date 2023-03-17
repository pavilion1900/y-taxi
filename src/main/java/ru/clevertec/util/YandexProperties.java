package ru.clevertec.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "yandex")
@ConstructorBinding
@Getter
@RequiredArgsConstructor
public class YandexProperties {

    private final String url;
    private final String clid;
    private final String apiKey;
}
