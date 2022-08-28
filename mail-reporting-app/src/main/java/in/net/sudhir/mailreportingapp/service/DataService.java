package in.net.sudhir.mailreportingapp.service;


import in.net.sudhir.mailreportingapp.model.Statistics;
import in.net.sudhir.mailreportingapp.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/***
 Package Name: in.net.sudhir.mailprocessor.mailprocessor.service
 User Name: SUDHIR
 Created Date: 20-08-2022 at 06:35
 Description:
 */
@Service("dataService")
public class DataService {


    @Autowired
    StatisticsRepository statisticsRepository;

    public Iterable<Statistics> getAllStats(){
        return statisticsRepository.findAllByOrderByCountDesc();
    }

}
