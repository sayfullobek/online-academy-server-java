package it.UTeam.Onlinevideoacademyserverjava.pyload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDto {
    private String phoneNumber;
    private String password;
}
