package ru.odintsov.cbrf.parser;


import ru.odintsov.cbrf.model.MoneyRate;

import java.util.List;

public interface MoneyRateParser {

    List<MoneyRate> parse(String rate) throws Exception;
}
