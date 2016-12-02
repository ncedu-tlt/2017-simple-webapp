package model;

import javax.xml.bind.annotation.XmlElement;

public class Market {

    private long id;
    private String name;

    public Market() {
    }

    public Market(String name) {
        this.name = name;
    }

    public Market(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    @XmlElement
    public  void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

}