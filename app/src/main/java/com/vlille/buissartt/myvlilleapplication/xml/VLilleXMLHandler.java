package com.vlille.buissartt.myvlilleapplication.xml;

import android.util.Log;

import com.vlille.buissartt.myvlilleapplication.beans.StationVLille;
import com.vlille.buissartt.myvlilleapplication.utils.Constants;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by buissartt on 29/09/2014.
 */
public class VLilleXMLHandler extends DefaultHandler {
    private StationVLille stationVLille;
    private String tempNode;

    public StationVLille getStationVLille() {
        return stationVLille;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equals(Constants.STATION))
            this.stationVLille = new StationVLille();

    }

    @Override
    public void characters(char[] chars, int start, int length) {
        tempNode = new String(chars,start,length);
    }

    @Override
    public void endElement(String uri, String localName, String node) {
        if(node.equals(Constants.ADRESS))
            stationVLille.setAdress(tempNode);
        if(node.equals(Constants.ATTACHS))
            stationVLille.setAttachs(Integer.valueOf(tempNode));
        if(node.equals(Constants.BIKES))
            stationVLille.setBikesLeft(Integer.valueOf(tempNode));
    }
}
