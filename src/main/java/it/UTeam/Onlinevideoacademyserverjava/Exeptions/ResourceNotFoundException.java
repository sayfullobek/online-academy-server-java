package it.UTeam.Onlinevideoacademyserverjava.Exeptions;

import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus
public class ResourceNotFoundException extends RuntimeException {
    private final String resourceName;
    private final String fieldName;
    private final Object fieldValue;
    private final Integer status;

    public ResourceNotFoundException(Integer status, String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s - %s not found with %s : '%s'", status, resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.status = status;
    }

}
