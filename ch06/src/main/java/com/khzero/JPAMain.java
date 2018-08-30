package com.khzero;

import com.khzero.model.UserEntity;
import com.khzero.model.UserRole;
import com.khzero.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JPAMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JPAMain.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);

        userRepository.save(new UserEntity("윤사장", 60, UserRole.ADMIN));
        UserEntity user = userRepository.findByUserName("윤사장");
        System.out.println("나이:"+user.getAge() + ","+"이름:" + user.getUserName()+","+"생성일:"+user.getCreatedAt());
    }
}
