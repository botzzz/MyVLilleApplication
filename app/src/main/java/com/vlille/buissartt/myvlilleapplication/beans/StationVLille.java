package com.vlille.buissartt.myvlilleapplication.beans;

/**
 * Created by buissartt on 25/09/2014.
 */
public class StationVLille {

    private String id;

    private Double lat;

    private Double lon;

    private String name;

    private Integer bikesLeft;

    private Integer attachs;

    private String adress;


    /**
     *
     */
    public StationVLille() {
    }

    public Integer getAttachs() {
        return attachs;
    }

    public void setAttachs(Integer attachs) {
        this.attachs = attachs;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBikesLeft() {
        return bikesLeft;
    }

    public void setBikesLeft(Integer bikesLeft) {
        this.bikesLeft = bikesLeft;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StationVLille{");
        sb.append("id='").append(id).append('\'');
        sb.append(", lat=").append(lat);
        sb.append(", lon=").append(lon);
        sb.append(", name='").append(name).append('\'');
        sb.append(", bikesLeft=").append(bikesLeft);
        sb.append(", attachs=").append(attachs);
        sb.append(", adress='").append(adress).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
