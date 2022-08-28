package in.net.sudhir.mailreportingapp;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import in.net.sudhir.mailreportingapp.model.Statistics;
import in.net.sudhir.mailreportingapp.service.DataService;
import in.net.sudhir.mailreportingapp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEncryptableProperties
public class MailReportingAppApplication {

    @Autowired
    EmailService emailService;

    @Autowired
    DataService dataService;

    public static void main(String[] args) {
        SpringApplication.run(MailReportingAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            StringBuilder stringBuilder = new StringBuilder("");
            Iterable<Statistics> statistics = dataService.getAllStats();
            stringBuilder.append("<!DOCTYPE html><html><head><title></title><meta charset=\"UTF-8\"></head><body><table border=\"1\" style=\"border-collapse:collapse\"><tr><th>id</th><th>count</th><th>email_address</th></tr>");
            statistics.forEach(statistic -> {
                stringBuilder.append(String.format("<tr><td>%s</td><td>%d</td><td>%s</td></tr>", statistic.getId(), statistic.getCount(), statistic.getEmailAddress()));
            });
            stringBuilder.append("</table></body><html>");
            emailService.sendStatisticsReport(stringBuilder.toString());
        };
    }


}
