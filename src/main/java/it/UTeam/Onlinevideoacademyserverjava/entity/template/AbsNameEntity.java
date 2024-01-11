package it.UTeam.Onlinevideoacademyserverjava.entity.template;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbsNameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String uzName;
    @Column(nullable = false)
    private String enName;
    @Column(nullable = false)
    private String ruName;
}
