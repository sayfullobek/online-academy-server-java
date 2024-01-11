package it.UTeam.Onlinevideoacademyserverjava.pyload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class ApiResponse<T> implements Serializable {
    private String message;
    private boolean success;
    private Integer status;
    private ResToken resToken;
    private Object user;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public ApiResponse(String message, boolean success, Integer status, Object user) {
        this.message = message;
        this.success = success;
        this.status = status;
        this.user = user;
    }

    public ApiResponse(String message, boolean success, Integer status) {
        this.message = message;
        this.success = success;
        this.status = status;
    }
}