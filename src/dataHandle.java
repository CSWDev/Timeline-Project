//import jdk.nashorn.internal.parser.JSONParser;

import org.json.JSONException;
import org.w3c.dom.*;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;


//import javax.swing.*;

public class dataHandle
{

    static ArrayList<superUser> users = new ArrayList<>();
    static ArrayList<Event> event = new ArrayList<>();
    static ArrayList<Figure> figures = new ArrayList<>();

    static String filename = "users.xml";
    static String filename2 = "events.xml";
    static String filename3 = "figures.xml";


    public static void saveUsersToFile() throws Exception
    {
        int userrange1 = 0;
        int userange2 = 0;
        try
        {
            //FINE
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            //--------------------------------------------
            //Create the xml element
            Element element = document.createElement("Users");
            document.appendChild(element);
            //create the attributes
            Attr start = document.createAttribute("userrange1");
            start.setValue(Integer.toString(userrange1));
            element.setAttributeNode(start);

            Attr end = document.createAttribute("userrange2");
            end.setValue(Integer.toString(userange2));
            element.setAttributeNode(end);

            //for loop to extract the values from the arraylist
            for (int i = 0; i < users.size(); i++)
            {

                Element index = document.createElement("Users");
                element.appendChild(index);

                Element username = document.createElement("Username");
                username.appendChild(document.createTextNode(users.get(i).getUsername()));
                index.appendChild(username);

                Element Firstname = document.createElement("Firstname");
                Firstname.appendChild(document.createTextNode(users.get(i).getFirstname()));
                index.appendChild(Firstname);

                Element lastname = document.createElement("Lastname");
                lastname.appendChild(document.createTextNode(users.get(i).getLastname()));
                index.appendChild(lastname);

                Element Password = document.createElement("Password");
                Password.appendChild(document.createTextNode(users.get(i).getPassword()));
                index.appendChild(Password);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            StreamResult streamResult = new StreamResult(filename);

            transformer.transform(source, streamResult);
            //readUsernameFromFile();

        }
        catch (ParserConfigurationException pce)
        {
            pce.printStackTrace();
        }
        catch (TransformerException tfe)
        {
            tfe.printStackTrace();
        }


    }

    public static void saveEventToFile() throws Exception
    {
        int startYear = 1900;
        int endYear = 1999;
        try
        {
            //FINE
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            //--------------------------------------------
            //Create the xml element
            Element element = document.createElement("Event");
            document.appendChild(element);
            //create the attributes
            Attr start = document.createAttribute("startDate");
            start.setValue(Integer.toString(startYear));
            element.setAttributeNode(start);

            Attr end = document.createAttribute("endDate");
            end.setValue(Integer.toString(endYear));
            element.setAttributeNode(end);

            //for loop to extract the values from the arraylist
            for (int i = 0; i < event.size(); i++)
            {

                Element index = document.createElement("Event");
                element.appendChild(index);

                Element title = document.createElement("Title");
                title.appendChild(document.createTextNode(event.get(i).getTitle()));
                index.appendChild(title);

                Element startDate = document.createElement("StartDate");
                startDate.appendChild(document.createTextNode(Integer.toString(event.get(i).getStartDate())));
                index.appendChild(startDate);

                Element endDate = document.createElement("EndDate");
                endDate.appendChild(document.createTextNode(Integer.toString(event.get(i).getEndDate())));
                index.appendChild(endDate);

                Element Details = document.createElement("Details");
                Details.appendChild(document.createTextNode(event.get(i).getDetails()));
                index.appendChild(Details);

                Element Links = document.createElement("Links");
                Links.appendChild(document.createTextNode(event.get(i).getLinks()));
                index.appendChild(Links);

                Element imgpath = document.createElement("Imgpath");
                imgpath.appendChild(document.createTextNode(event.get(i).getImg()));
                index.appendChild(imgpath);

            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            StreamResult streamResult = new StreamResult(new File(filename2));

            transformer.transform(source, streamResult);
            //loadEventFromFile(filename2);

        }
        catch (ParserConfigurationException pce)
        {
            pce.printStackTrace();
        }
        catch (TransformerException tfe)
        {
            tfe.printStackTrace();
        }


    }

    public static void saveFigureToFile() throws Exception
    {
        int teset = 1900;
        int test = 1999;
        try
        {
            //FINE
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            //--------------------------------------------
            //Create the xml element
            Element element = document.createElement("Figure");
            document.appendChild(element);
            //create the attributes
            Attr start = document.createAttribute("startDate");
            start.setValue(Integer.toString(teset));
            element.setAttributeNode(start);

            Attr end = document.createAttribute("endDate");
            end.setValue(Integer.toString(test));
            element.setAttributeNode(end);

            //for loop to extract the values from the arraylist
            for (int i = 0; i < figures.size(); i++)
            {

                Element index = document.createElement("Figure");
                element.appendChild(index);

                Element first = document.createElement("firstname");
                first.appendChild(document.createTextNode(figures.get(i).getFirstname()));
                index.appendChild(first);

                Element second = document.createElement("Surname");
                second.appendChild(document.createTextNode(figures.get(i).getLastname()));
                index.appendChild(second);

                Element DOB = document.createElement("dob");
                DOB.appendChild(document.createTextNode(String.valueOf(figures.get(i).getDOB())));
                index.appendChild(DOB);

                Element DOD = document.createElement("dod");
                DOD.appendChild(document.createTextNode(String.valueOf(figures.get(i).getDOD())));
                index.appendChild(DOD);

                Element Details = document.createElement("Details");
                Details.appendChild(document.createTextNode(figures.get(i).getDetails()));
                index.appendChild(Details);


            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            StreamResult streamResult = new StreamResult(new File(filename3));

            transformer.transform(source, streamResult);
            //loadEventFromFile(filename2);

        }
        catch (ParserConfigurationException pce)
        {
            pce.printStackTrace();
        }
        catch (TransformerException tfe)
        {
            tfe.printStackTrace();
        }


    }

    public static void readUsernameFromFile()
    {
        try
        {
            File file = new File(filename);
            DocumentBuilderFactory docFac = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBld = docFac.newDocumentBuilder();
            Document document = docBld.parse(file);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("Users");


            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) node;
                    String usrnm = element.getElementsByTagName("Username").item(0).getTextContent();
                    String pass = element.getElementsByTagName("Password").item(0).getTextContent();
                    superUser login = new superUser();
                    login.setUsername(usrnm);
                    login.setPassword(pass);

                    loginMain.credentials.add(login);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void readEventFromFile()
    {
        try
        {
            File file = new File(filename2);
            DocumentBuilderFactory docFac = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBld = docFac.newDocumentBuilder();
            Document document = docBld.parse(file);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("Event");

            for (int inx = 0; inx < nodeList.getLength(); inx++)
            {
                Node node = nodeList.item(inx);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) node;
                    String Title = element.getElementsByTagName("Title").item(0).getTextContent();
                    int SD = Integer.parseInt(element.getElementsByTagName("StartDate").item(0).getTextContent());
                    int ED = Integer.parseInt(element.getElementsByTagName("EndDate").item(0).getTextContent());
                    String Details = element.getElementsByTagName("Details").item(0).getTextContent();
                    String lks = element.getElementsByTagName("Links").item(0).getTextContent();
                    String imgpth = element.getElementsByTagName("Imgpath").item(0).getTextContent();

                    Event New = new Event(Title, SD, ED, Details, lks, imgpth);
                    timeline1900.aEvent.add(New);
                    editEvent.aEvent.add(New);
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void readFigureFromFile()
    {
        try
        {
            File file = new File(filename3);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("Figure");

            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) node;
                    String Firstname = element.getElementsByTagName("firstname").item(0).getTextContent();
                    String Lastname = element.getElementsByTagName("Surname").item(0).getTextContent();
                    int dob = Integer.parseInt(element.getElementsByTagName("dob").item(0).getTextContent());
                    int dod = Integer.parseInt(element.getElementsByTagName("dod").item(0).getTextContent());
                    String Details = element.getElementsByTagName("Details").item(0).getTextContent();

                    Figure fig = new Figure(Firstname, Lastname, dob, dod, Details);
                    viewFigures.aFigure.add(fig);
                    addEvent.aFigure.add(fig);


                }

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
