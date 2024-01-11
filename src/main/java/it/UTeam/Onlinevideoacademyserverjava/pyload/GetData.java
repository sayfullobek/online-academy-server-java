package it.UTeam.Onlinevideoacademyserverjava.pyload;

import it.UTeam.Onlinevideoacademyserverjava.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetData {
    private User user;
    private ResToken resToken;

}
