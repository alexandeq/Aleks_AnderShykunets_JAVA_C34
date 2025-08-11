package org.example;

import org.example.dto.SearchDto;
import org.example.entity.Brand;
import org.example.entity.CarEntity;
import org.example.service.CarService;

public class Main {

    private static final CarService service = new CarService();

    public static void main(String[] args) {


        CarEntity car1 = new CarEntity(Brand.PORSCHE, 90000, 10000, 2019);
        CarEntity car2 = new CarEntity(Brand.MERCEDES_BENZ, 60000, 5000, 2024);
        CarEntity car3 = new CarEntity(Brand.AUDI, 50000, 100000, 2017);

        service.save(car1);
        service.save(car2);
        service.save(car3);

        SearchDto searchDto1 = new SearchDto(Brand.PORSCHE, 50000, 150000, 9000, 15000,2018);
        SearchDto searchDto2 = new SearchDto(Brand.MERCEDES_BENZ, null, null, null, null,null);
        SearchDto searchDto3 = new SearchDto(Brand.AUDI, 50000, 60000, null, null,null);

        service.search(searchDto1);
        service.search(searchDto2);
        service.search(searchDto3);

    }
}