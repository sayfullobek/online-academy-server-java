package it.UTeam.Onlinevideoacademyserverjava.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JpaConverterJson implements AttributeConverter<Object, String> {


    private static final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public String convertToDatabaseColumn(Object o) {
        try {
            return objectMapper.writeValueAsString(o);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object convertToEntityAttribute(String s) {
        try {
            return objectMapper.readValue(s, Object.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
