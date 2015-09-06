package com.codeofdan.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class JAXBExample {

    private static JAXBContext jaxbContext;

    public static void main(String[] args) throws Exception {
        jaxbContext = JAXBContext.newInstance(Person.class, Address.class);
        convertToXml();
        parseXml();
    }

    private static void convertToXml() throws JAXBException {
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Person person = new Person();
        person.setName("Dan");
        person.setAge(24);

        Address address = new Address();
        address.setAddress1("123 My Lane");
        address.setCity("Mytown");
        address.setPostcode("AB1 1CD");

        person.setAddress(address);

        marshaller.marshal(person, System.out);
    }


    private static void parseXml() throws JAXBException {
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<person>" +
                "<address>" +
                "<address1>123 My Lane</address1>" +
                "<city>Mytown</city>" +
                "<postcode>AB1 1CD</postcode>" +
                "</address>" +
                "<age>24</age>" +
                "<name>Dan</name>" +
                "</person>";

        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());

        Person person = unmarshaller.unmarshal(new StreamSource(inputStream), Person.class).getValue();

        System.out.println(person.getName());
        System.out.println(person.getAge());

        Address address = person.getAddress();

        System.out.println(address.getAddress1());
        System.out.println(address.getCity());
        System.out.println(address.getPostcode());

    }
}
