package it.UTeam.Onlinevideoacademyserverjava.config;

import org.springframework.core.io.ClassPathResource;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

public class InitConfig {
    public static boolean isStart() {
        Properties properties = new Properties();
        try {
            properties.load(new ClassPathResource("/application.properties").getInputStream());
            if (properties.getProperty("spring.jpa.hibernate.ddl-auto").equals("update")) {
                return true;
            } else {
                String code = JOptionPane.showInputDialog("Ma'lumotlar bazasi create yoki create-drop holatida ma'lumotlar o'chib ketadi rostdanham run bermoqchi bol'lsangiz parolni kiriting");
                if (code != null && code.equals("Hello tashkent")) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
