package com.vupt.application.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    public static void decodeXMLString() {
        String encodedString = "77u/PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4NCjxUT05HX0hPUD4NCiAgPE1BX0xLPlROLjI0MDYuMDAwNzk1MzwvTUFfTEs+DQogIDxTVFQ+MTwvU1RUPg0KICA8TUFfQk4+MjQwMDE3MjM8L01BX0JOPg0KICA8SE9fVEVOPkjhu5IgVEhVIE5HVVnhu4ZUPC9IT19URU4+DQogIDxTT19DQ0NEIC8+DQogIDxOR0FZX1NJTkg+MTk3NjExMDQwMDAwPC9OR0FZX1NJTkg+DQogIDxHSU9JX1RJTkg+MjwvR0lPSV9USU5IPg0KICA8TkhPTV9NQVUgLz4NCiAgPE1BX1FVT0NUSUNIPjAwMDwvTUFfUVVPQ1RJQ0g+DQogIDxNQV9EQU5UT0M+MDE8L01BX0RBTlRPQz4NCiAgPE1BX05HSEVfTkdISUVQPjUxNTIwPC9NQV9OR0hFX05HSElFUD4NCiAgPERJQV9DSEk+LiwgWMOjIE3hu7kgSGnhu4dwIFPGoW4sIEh1eeG7h24gSMOybiDEkOG6pXQsIFThu4luaCBLacOqbiBHaWFuZzwvRElBX0NIST4NCiAgPE1BVElOSF9DVV9UUlU+OTE8L01BVElOSF9DVV9UUlU+DQogIDxNQUhVWUVOX0NVX1RSVT45MDM8L01BSFVZRU5fQ1VfVFJVPg0KICA8TUFYQV9DVV9UUlU+MzA4MzI8L01BWEFfQ1VfVFJVPg0KICA8RElFTl9USE9BSSAvPg0KICA8TUFfVEhFX0JIWVQ+R0Q0NzU3OTExMTQyNDQyPC9NQV9USEVfQkhZVD4NCiAgPE1BX0RLQkQ+NzUwMDg8L01BX0RLQkQ+DQogIDxHVF9USEVfVFU+MjAyNTA1MDc8L0dUX1RIRV9UVT4NCiAgPEdUX1RIRV9ERU4+MjAyNTA1MDc8L0dUX1RIRV9ERU4+DQogIDxOR0FZX01JRU5fQ0NUIC8+DQogIDxMWV9ET19WVj5LaMOhbSBi4buHbmg8L0xZX0RPX1ZWPg0KICA8TFlfRE9fVk5UIC8+DQogIDxNQV9MWV9ET19WTlQgLz4NCiAgPENIQU5fRE9BTl9WQU8+TGnhu4d0IG7hu61hIG5nxrDhu51pOzwvQ0hBTl9ET0FOX1ZBTz4NCiAgPENIQU5fRE9BTl9SVj5MaeG7h3QgbuG7rWEgbmfGsOG7nWk8L0NIQU5fRE9BTl9SVj4NCiAgPE1BX0JFTkhfQ0hJTkg+RzgxPC9NQV9CRU5IX0NISU5IPg0KICA8TUFfQkVOSF9LVCAvPg0KICA8TUFfQkVOSF9ZSENUIC8+DQogIDxNQV9QVFRUX1FUIC8+DQogIDxNQV9ET0lUVU9OR19LQ0I+MS4xPC9NQV9ET0lUVU9OR19LQ0I+DQogIDxNQV9OT0lfREkgLz4NCiAgPE1BX05PSV9ERU4gLz4NCiAgPE1BX1RBSV9OQU4+MDwvTUFfVEFJX05BTj4NCiAgPE5HQVlfVkFPPjIwMjQwNjIwMDgyODwvTkdBWV9WQU8+DQogIDxOR0FZX1ZBT19OT0lfVFJVIC8+DQogIDxOR0FZX1JBPjIwMjQwNzA0MDgyNTwvTkdBWV9SQT4NCiAgPEdJQVlfQ0hVWUVOX1RVWUVOIC8+DQogIDxTT19OR0FZX0RUUkk+MDwvU09fTkdBWV9EVFJJPg0KICA8UFBfRElFVV9UUkkgLz4NCiAgPEtFVF9RVUFfRFRSST4xPC9LRVRfUVVBX0RUUkk+DQogIDxNQV9MT0FJX1JWPjE8L01BX0xPQUlfUlY+DQogIDxHSElfQ0hVIC8+DQogIDxOR0FZX1RUT0FOPjIwMjQwNzA0MDgyNTwvTkdBWV9UVE9BTj4NCiAgPFRfVEhVT0M+MCwwMDwvVF9USFVPQz4NCiAgPFRfVlRZVD4wLDAwPC9UX1ZUWVQ+DQogIDxUX1RPTkdDSElfQlY+NjA4NzAwLDAwPC9UX1RPTkdDSElfQlY+DQogIDxUX1RPTkdDSElfQkg+NjA4NzAwLDAwPC9UX1RPTkdDSElfQkg+DQogIDxUX0JOVFQ+MCwwMDwvVF9CTlRUPg0KICA8VF9CTkNDVD4xMjE3NDAsMDA8L1RfQk5DQ1Q+DQogIDxUX0JIVFQ+NDg2OTYwLDAwPC9UX0JIVFQ+DQogIDxUX05HVU9OS0hBQz4wLDAwPC9UX05HVU9OS0hBQz4NCiAgPFRfQkhUVF9HRFY+MDwvVF9CSFRUX0dEVj4NCiAgPE5BTV9RVD4yMDI0PC9OQU1fUVQ+DQogIDxUSEFOR19RVD43PC9USEFOR19RVD4NCiAgPE1BX0xPQUlfS0NCPjAyPC9NQV9MT0FJX0tDQj4NCiAgPE1BX0tIT0E+SzAxPC9NQV9LSE9BPg0KICA8TUFfQ1NLQ0I+NzUwMDg8L01BX0NTS0NCPg0KICA8TUFfS0hVVlVDIC8+DQogIDxDQU5fTkFORz41NS4wMDwvQ0FOX05BTkc+DQogIDxDQU5fTkFOR19DT04gLz4NCiAgPE5BTV9OQU1fTElFTl9UVUMgLz4NCiAgPE5HQVlfVEFJX0tIQU0+MjAyNDA2MjA8L05HQVlfVEFJX0tIQU0+DQogIDxNQV9IU0JBPlROLjI0MDYuMDAwNzk1MzwvTUFfSFNCQT4NCiAgPE1BX1RURFYgLz4NCiAgPERVX1BIT05HIC8+DQo8L1RPTkdfSE9QPg==";

        byte[] decodedBytes = DatatypeConverter.parseBase64Binary(encodedString);
        String decodeXML = new String(decodedBytes);

        System.out.println(decodeXML);
    }

    public static void readXMLToJava() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            System.out.println(TestUtils.class.getResource("/xml/readXMLToJava.xml").getPath());
            Document document = builder.parse(TestUtils.class.getResource("/xml/readXMLToJava.xml").getPath());

            NodeList customTags = document.getElementsByTagName("customTag");
            List<String> customList = new ArrayList<>();

            for (int i = 0; i < customTags.getLength(); i++) {
                Element customTag = (Element) customTags.item(i);
                String attributeValue = customTag.getAttribute("attribute1");
                String subTagContent = customTag.getElementsByTagName("subTag").item(0).getTextContent();
                String customEntry = attributeValue + " - " + subTagContent;
                customList.add(customEntry);
            }

            // Print the list
            for (String entry : customList) {
                System.out.println(entry);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void buildCustomXML() {
        try {
            // Create a new XML document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Root element
            Element rootElement = doc.createElement("data");
            doc.appendChild(rootElement);

            // Custom tag
            Element customTag = doc.createElement("customTag");
            customTag.setAttribute("attribute1", "value1");
            rootElement.appendChild(customTag);

            // Sub tag within custom tag
            Element subTag = doc.createElement("subTag");
            subTag.appendChild(doc.createTextNode("This is content within the custom tag."));
            customTag.appendChild(subTag);

            // Write the content into an XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("custom.xml");
            transformer.transform(source, result);

            System.out.println("File saved!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
