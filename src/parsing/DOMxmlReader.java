package parsing;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMxmlReader {

    public List<Valute> readFile(String filepath) {

        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        List<Valute> valList = new ArrayList<Valute>();
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            // получаем узлы с именем Valute
            // теперь XML полностью загружен в память
            // в виде объекта Document
            NodeList nodeList = document.getElementsByTagName("Valute");

            for (int i = 0; i < nodeList.getLength(); i++) {
                valList.add(getValute(nodeList.item(i)));
            }

            // печатаем в консоль информацию по каждому объекту Language
            //for (Valute val : valList) {
            //    System.out.println(val.toString());}
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return valList;
    }

    // создаем из узла документа объект Valute
    private static Valute getValute(Node node) {
        Valute val = new Valute();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            val.setNumCode(getTagValue("NumCode", element));
            val.setCharCode(getTagValue("CharCode", element));
            val.setNominal(Integer.parseInt(getTagValue("Nominal", element)));
            val.setName(getTagValue("Name", element));
            val.setValue(Double.parseDouble(getTagValue("Value", element).replace(",", ".")));
        }

        return val;
    }

    // получаем значение элемента по указанному тегу
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    public static void shouldReturnStatusOkay() throws UnirestException {
        HttpResponse jsonResponse
                = (HttpResponse) Unirest.get("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
                .header("accept", "application/json").queryString("apiKey", "123")
                .asJson();

        assertNotNull(jsonResponse.getBody());
        assertEquals(200, jsonResponse.getStatus());
    }

}

