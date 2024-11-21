package com.stulikov.public_transport_stops_on_spring.timeUpdate;


import com.stulikov.public_transport_stops_on_spring.hybernate.TimeUpdateDBRepository;
import com.stulikov.public_transport_stops_on_spring.transformation.Unmarshalling;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.xml.bind.JAXBException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
@Component("timeUpdateUsingDataBaseBean")
public class TimeUpdateUsingDataBase implements TimeUpdate  {

    private URL urlTimeUpdate = new URL("https://tosamara.ru/api/v2/classifiers");

    private TimeUpdateDBRepository timeUpdateDBRepository;

    private Classifiers classifiers;

    @Autowired
    public TimeUpdateUsingDataBase(@Qualifier("timeUpdateMySQLRepositoryBean") TimeUpdateDBRepository timeUpdateDBRepository) throws MalformedURLException {
        this.timeUpdateDBRepository = timeUpdateDBRepository;

    }

    public TimeUpdateUsingDataBase() throws MalformedURLException {
    }

    @Override
    public boolean updateOrNot() throws IOException, JAXBException, SQLException, ClassNotFoundException {
          classifiers = Unmarshalling.unmarshallTimeUpdate(urlTimeUpdate);
            Double oldTimeUpdate = timeUpdateDBRepository.selectTimeUpdateFromTable();
            Double newTimeUpdate = classifiers.getTimeUpdate();
            if (oldTimeUpdate == null || newTimeUpdate > oldTimeUpdate) {
                oldTimeUpdate = newTimeUpdate;
                timeUpdateDBRepository.upsertTimeUpdateToTable(oldTimeUpdate);
                return true;
            }

        return false;
    }
}


