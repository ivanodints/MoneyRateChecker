package ru.odintsov.cbrf.getXML;

import java.io.IOException;

public interface GetXML {

    String getXMLRequest(String url) throws IOException, InterruptedException;
}
