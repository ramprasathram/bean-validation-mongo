package com.example.beanvalidationmongo.config;

import com.example.beanvalidationmongo.document.Users;
import com.example.beanvalidationmongo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDbConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            LocalDate date = LocalDate.parse("2020-12-12");
            List<String> listHobbies = new ArrayList<String>();
            listHobbies.add("Song");
            listHobbies.add("Reading");
            userRepository.save(new Users(1, "Sanoaf", "Developer", 30000L, "sano@google.com", "9898978765", date, listHobbies));
            userRepository.save(new Users(2, "Kamil", "Chemist", 40000L, "sano@google.com", "9898978765", date, listHobbies));
            userRepository.save(new Users(3, "Sam", "Civil", 50000L, "sano@google.com", "9898978765", date, listHobbies));
            userRepository.save(new Users(4, "Santhosh", "Civil", 60000L, "sano@google.com", "9898978765", date, listHobbies));
            userRepository.save(new Users(5, "Vijay", "Cine", 100000L, "sano@google.com", "9898978765", date, listHobbies));
            userRepository.save(new Users(6, "Surya", "Cine", 150000L, "sano@google.com", "9898978765", date, listHobbies));
        };
    }
}
