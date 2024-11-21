package com.stulikov.public_transport_stops_on_spring.experiments.xmlSpring;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class RunApplication {

    // Main driver method
    public static void main(String[] args)
            throws IOException
    {

        // Try block to check for exceptions
        try (AnnotationConfigApplicationContext ctx
                     = new AnnotationConfigApplicationContext()) {
            ctx.register(AppConfig.class);
            ctx.refresh();
            Processor processor
                    = ctx.getBean(Processor.class);

            // Perform Marshalling
            Company company = new Company();
            company.setId(1000);
            company.setCompanyName("XYZ");
            company.setCeoName("ABCD");
            company.setNoEmp(100);
            processor.objectToXML("company.xml", company);

            // Display message only
            System.out.println("Marshalling performed");

            // Perform UnMarshalling
            company = (Company)processor.xmlToObject(
                    "company.xml");

            // Display message only
            System.out.println(
                    "After UnMarshalling Data is: id:"
                            + company.getId() + ", CountryName:"
                            + company.getCompanyName());
        }

        // Catch block to handle exceptions
        catch (BeansException | IllegalStateException e) {

            // Display exceptions along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
    }
}
