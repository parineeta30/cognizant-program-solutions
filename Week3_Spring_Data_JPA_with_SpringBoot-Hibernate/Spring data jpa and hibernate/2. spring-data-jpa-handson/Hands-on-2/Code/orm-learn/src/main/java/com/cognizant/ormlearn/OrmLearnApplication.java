package com.cognizant.ormlearn;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

@SpringBootApplication
public class OrmLearnApplication {

    private static StockRepository stockRepository;

    private static void testFacebookSeptember2019Stocks() {
        System.out.println("---- Facebook Stocks in September 2019 ----");
        List<Stock> list = stockRepository.findByCodeAndDateBetween(
                "FB",
                LocalDate.of(2019, 9, 1),
                LocalDate.of(2019, 9, 30)
        );
        list.forEach(System.out::println);
    }
private static void testGoogleStocksGreaterThan1250() {
        System.out.println("---- Google Stocks with Close > 1250 ----");
        List<Stock> list = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", BigDecimal.valueOf(1250.00));
        list.forEach(System.out::println);
    }

    private static void testTop3HighestVolumeStocks() {
        System.out.println("---- Top 3 Stocks with Highest Volume ----");
        List<Stock> list = stockRepository.findTop3ByOrderByVolumeDesc();
        list.forEach(System.out::println);
    }

    private static void testLowestNetflixStockPrices() {
        System.out.println("---- Netflix Stocks with Lowest Closing Prices ----");
        List<Stock> list = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        stockRepository = context.getBean(StockRepository.class);

        //testFacebookSeptember2019Stocks();
         testGoogleStocksGreaterThan1250();
        testTop3HighestVolumeStocks();
        testLowestNetflixStockPrices();
    }
}