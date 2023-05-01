package ua.lviv.iot.docslab.repositiry.csv;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import ua.lviv.iot.docslab.dto.OrderCsvDto;

public class CsvUtils {

    private static final String CSV_FILE_CONTENT_PATH = "./src/main/java/ua/lviv/iot/docslab/data/orders.csv";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final CSVFormat CSV_FORMAT = CSVFormat.DEFAULT
            .builder()
            .setHeader("insuranceId", "userId", "createdAt")
            .setSkipHeaderRecord(true)
            .build();

    private CsvUtils() {
    }

    public static void writeOrdersToCsv(List<OrderCsvDto> orders) {
        File file = new File(CSV_FILE_CONTENT_PATH);
        try (Writer writer = new FileWriter(file);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSV_FORMAT)) {
            csvPrinter.printRecord("insuranceId", "userId", "createdAt");
            for (OrderCsvDto o : orders) {
                csvPrinter.printRecord(o.getInsuranceId(), o.getUserId(), o.getCreatedAt().format(DATE_TIME_FORMATTER));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<OrderCsvDto> readOrdersFromCsv() {
        List<OrderCsvDto> orders = new ArrayList<>();
        try (Reader reader = new FileReader(CSV_FILE_CONTENT_PATH);
             CSVParser csvParser = new CSVParser(reader, CSV_FORMAT)) {
            for (CSVRecord csvRecord : csvParser.getRecords()) {
                OrderCsvDto order = new OrderCsvDto(
                        Long.valueOf(csvRecord.get("insuranceId")),
                        Long.valueOf(csvRecord.get("userId")),
                        LocalDateTime.parse(csvRecord.get("createdAt"), DATE_TIME_FORMATTER)
                );
                orders.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
