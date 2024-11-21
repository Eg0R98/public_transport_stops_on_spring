package com.stulikov.public_transport_stops_on_spring.experiments.xmlSpring;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.FIELD)
// Class
public class Company {

    // Class data members
    @XmlElement(name = "id")
    private Integer id;
    @XmlElement(name = "company-name")
    private String companyName;
    @XmlElement(name = "ceo-name")
    private String ceoName;
    @XmlElement(name = "no-emp")
    private Integer noEmp;

    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id)
    {
        // this keyword refers to current itself
        this.id = id;
    }

    // Getter and Setter
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    // Getter and Setter
    public String getCeoName() { return ceoName; }
    public void setCeoName(String ceoName)
    {
        this.ceoName = ceoName;
    }

    // Getter and Setter
    public Integer getNoEmp() { return noEmp; }
    public void setNoEmp(Integer noEmp)
    {
        this.noEmp = noEmp;
    }
}
