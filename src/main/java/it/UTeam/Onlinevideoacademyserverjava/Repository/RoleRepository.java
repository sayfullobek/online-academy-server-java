package it.UTeam.Onlinevideoacademyserverjava.Repository;

import it.UTeam.Onlinevideoacademyserverjava.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
