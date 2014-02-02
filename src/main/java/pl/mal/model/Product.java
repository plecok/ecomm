package pl.mal.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: plecok
 * Date: 01.02.14
 * Time: 19:57
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class Product {

    private String name;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
