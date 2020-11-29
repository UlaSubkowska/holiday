package com.bs.holiday.dao;

import com.bs.holiday.model.HolidayEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class HolidayDao {

    public HolidayEntity[] getHolidayEntities() {
        WebClient webClient = WebClient.create("https://public-holiday.p.rapidapi.com");
        Mono<HolidayEntity[]> result = webClient.get()
                .uri("/2019/PL")
                .header("x-rapidapi-key", System.getenv("BS_HOLIDAY_API_KEY"))
                .header("x-rapidapi-host", "public-holiday.p.rapidapi.com")
                .retrieve()
                .bodyToMono(HolidayEntity[].class);
        return result.block();
    }
}
