package ru.odintsov.cbrf.service;

import org.xml.sax.SAXException;
import ru.odintsov.cbrf.model.MoneyRate;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;

public interface MoneyRateService {

    MoneyRate getMoneyRate(String currency) throws Exception;

}
