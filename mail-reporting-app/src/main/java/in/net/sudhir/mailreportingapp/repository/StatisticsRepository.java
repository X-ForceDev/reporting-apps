package in.net.sudhir.mailreportingapp.repository;


import in.net.sudhir.mailreportingapp.model.Statistics;
import org.springframework.data.repository.CrudRepository;

/***
 Package Name: in.net.sudhir.mailprocessor.mailprocessor.repository
 User Name: SUDHIR
 Created Date: 20-08-2022 at 10:56
 Description:
 */
public interface StatisticsRepository extends CrudRepository<Statistics, Long> {

    public Iterable<Statistics> findAllByOrderByCountDesc();
}
