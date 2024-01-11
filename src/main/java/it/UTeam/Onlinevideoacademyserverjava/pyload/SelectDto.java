package it.UTeam.Onlinevideoacademyserverjava.pyload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SelectDto {
    private UUID values;
    private Integer value;
    private String label;

}
