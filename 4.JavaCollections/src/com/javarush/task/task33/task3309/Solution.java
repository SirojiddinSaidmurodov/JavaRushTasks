package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, IOException {
        String xmlString = getXmlString(obj);
        BufferedReader reader = new BufferedReader(new StringReader(xmlString));
        String line;
        StringWriter resultWriter = new StringWriter();
        while ((line = reader.readLine()) != null) {
            if (line.contains(tagName)) {
                resultWriter.append("<!--").append(comment).append("-->\n");
            }
            resultWriter.append(line).append("\n");
        }
        return resultWriter.toString();
    }

    private static String getXmlString(Object obj) throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(obj, writer);
        return writer.toString();
    }

    public static void main(String[] args) {

    }
}
