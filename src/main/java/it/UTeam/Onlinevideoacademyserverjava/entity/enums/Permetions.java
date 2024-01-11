package it.UTeam.Onlinevideoacademyserverjava.entity.enums;

import java.util.Arrays;
import java.util.List;

public enum Permetions {
    AWARE("/api/v1/auth/aware/**", Arrays.asList(RoleName.SUPER_ADMIN, RoleName.MANAGER, RoleName.ADMIN));
    String securityPath;
    List<RoleName> roleNames;

    Permetions(String securityPath, List<RoleName> roleNames) {
        this.securityPath = securityPath;
        this.roleNames = roleNames;
    }

    Permetions() {

    }
}
