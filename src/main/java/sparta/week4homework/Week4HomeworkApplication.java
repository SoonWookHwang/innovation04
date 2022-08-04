package sparta.week4homework;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.sql.RowSet;


@EnableJpaAuditing
@SpringBootApplication
public class Week4HomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(Week4HomeworkApplication.class, args);

	}


}



