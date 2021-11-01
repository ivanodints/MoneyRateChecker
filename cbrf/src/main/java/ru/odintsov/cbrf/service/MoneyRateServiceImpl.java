package ru.odintsov.cbrf.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import ru.odintsov.cbrf.getXML.GetXML;
import ru.odintsov.cbrf.model.MoneyRate;
import ru.odintsov.cbrf.parser.MoneyRateParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class MoneyRateServiceImpl implements MoneyRateService {

    private static final String dateFormat = "dd/MM/yyyy";
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
    private static final LocalDate nowDate = LocalDate.now();
    private static final String cbrfURL = "https://www.cbr.ru/scripts/XML_daily.asp?date_req=";

    private final MoneyRateParser moneyRateParser;
    private final GetXML getXML;




    @Override
    public MoneyRate getMoneyRate(String currency) throws Exception {

        List<MoneyRate> moneyRateList;

//        String urlWithParams = String.format("%s?date_req=%s", cbrConfig.getUrl(), dateFormatter.format(nowDate));
        String urlWithParams = cbrfURL + dateFormatter.format(nowDate);
        String xmlRate = getXML.getXMLRequest(urlWithParams);
        moneyRateList = moneyRateParser.parse(xmlRate);

        MoneyRate moneyRate = moneyRateList.stream().filter(rate -> currency.equals(rate.getCharCode()))
                .findFirst()
                .orElseThrow(() -> new Exception("Данной валюты не найдено"));

        return moneyRate;
    }
}
