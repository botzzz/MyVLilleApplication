package com.vlille.buissartt.myvlilleapplication.provider;

import android.os.AsyncTask;
import android.util.Log;

import com.vlille.buissartt.myvlilleapplication.beans.StationVLille;
import com.vlille.buissartt.myvlilleapplication.utils.Constants;
import com.vlille.buissartt.myvlilleapplication.xml.VLilleXMLListHandler;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by buissartt on 25/09/2014.
 */
public class StationVLilleListProvider extends AsyncTask<Void, Void, List<StationVLille>> {
    @Override
    protected List<StationVLille> doInBackground(Void... voids) {

        VLilleXMLListHandler vLilleXmlListHandler = null;
        try {
            SAXParserFactory saxPF = SAXParserFactory.newInstance();
            SAXParser saxP = saxPF.newSAXParser();
            XMLReader xmlR = saxP.getXMLReader();

            URL url = new URL(Constants.URL_VLILLE); // URL of the XML

            /**
             * Create the Handler to handle each of the XML tags.
             **/
            vLilleXmlListHandler = new VLilleXMLListHandler();
            xmlR.setContentHandler(vLilleXmlListHandler);
            xmlR.parse(new InputSource(url.openStream()));

        }
        catch(Exception e){
            e.printStackTrace();
            Log.e("exception", e.toString());
        }
        return vLilleXmlListHandler.getStationsVLille();
    }
}
