package ru.odintsov.cbrf.parser;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import ru.odintsov.cbrf.model.MoneyRate;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class MoneyRateParserImpl implements MoneyRateParser{

    @Override
    public List<MoneyRate> parse(String xmlRate) throws Exception {

        List<MoneyRate> rates = new ArrayList<>();

        StringReader stringReader = new StringReader(xmlRate);

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        Document document = documentBuilderFactory.newDocumentBuilder().parse(new InputSource(stringReader));

        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("Valute");

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodeList.item(i);

                MoneyRate moneyRate = new MoneyRate(
                        element.getElementsByTagName("NumCode").item(0).getTextContent(),
                        element.getElementsByTagName("CharCode").item(0).getTextContent(),
                        element.getElementsByTagName("Nominal").item(0).getTextContent(),
                        element.getElementsByTagName("Name").item(0).getTextContent(),
                        element.getElementsByTagName("Value").item(0).getTextContent());
                rates.add(moneyRate);
            }
        }


        return rates;
    }
}
