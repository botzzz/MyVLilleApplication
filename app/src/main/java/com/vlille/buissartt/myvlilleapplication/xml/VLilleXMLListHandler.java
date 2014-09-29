package com.vlille.buissartt.myvlilleapplication.xml;

import android.util.Log;

import com.vlille.buissartt.myvlilleapplication.beans.StationVLille;
import com.vlille.buissartt.myvlilleapplication.utils.Constants;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by buissartt on 25/09/2014.
 */
public class VLilleXMLListHandler extends DefaultHandler {

    private List<StationVLille> stationsVLille;

    public List<StationVLille> getStationsVLille(){
        return stationsVLille;
    }

    @Override
    public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException {

        if (localName.equals(Constants.MARKERS)) {
            this.stationsVLille = new ArrayList<StationVLille>();
        } else if (localName.equals(Constants.MARKER)) {
            StationVLille stationVLille;

            String id = attributes.getValue(Constants.ID_VLILLE);

            VLilleXMLHandler vLilleXmlHandler = null;
            try {
                SAXParserFactory saxPF = SAXParserFactory.newInstance();
                SAXParser saxP = saxPF.newSAXParser();
                XMLReader xmlR = saxP.getXMLReader();

                URL url = new URL(Constants.URL_BORNE+ id); // URL of the XML
                /**
                 * Create the Handler to handle each of the XML tags.
                 **/
                vLilleXmlHandler = new VLilleXMLHandler();
                xmlR.setContentHandler(vLilleXmlHandler);
                xmlR.parse(new InputSource(url.openStream()));

            }
            catch(Exception e){
                e.printStackTrace();
                Log.e("exception", e.toString());
            }
            stationVLille = vLilleXmlHandler.getStationVLille();

            if (id != null)
                stationVLille.setId(id);

            String lat = attributes.getValue(Constants.LAT_VLILLE);
            if (lat != null)
                stationVLille.setLat(Double.valueOf(lat));

            String lon = attributes.getValue(Constants.LON_VLILLE);
            if (lon != null)
                stationVLille.setLon(Double.valueOf(lon));

            String name = attributes.getValue(Constants.NAME_VLILLE);
            if (name != null)
                stationVLille.setName(name);

            stationsVLille.add(stationVLille);
        }
    }
}
