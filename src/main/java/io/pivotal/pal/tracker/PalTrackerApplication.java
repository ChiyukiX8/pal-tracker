package io.pivotal.pal.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
<<<<<<< HEAD

@SpringBootApplication
public class PalTrackerApplication {
    public static void main(String args[]){
=======
import java.util.TimeZone;

@SpringBootApplication
public class PalTrackerApplication {

    public static void main(String[] args) {
        // Make sure the application runs as UTC
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
>>>>>>> c1d3eb0... Persist time entries in database
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    @Bean
<<<<<<< HEAD
    public TimeEntryRepository timeEntryRepository() {
        return new JdbcTimeEntryRepository(DataSource );
=======
    TimeEntryRepository timeEntryRepository(DataSource dataSource) {
        return new JdbcTimeEntryRepository(dataSource);
>>>>>>> c1d3eb0... Persist time entries in database
    }
}
