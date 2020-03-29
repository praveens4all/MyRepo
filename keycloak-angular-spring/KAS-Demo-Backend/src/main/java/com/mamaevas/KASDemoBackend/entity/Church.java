package com.mamaevas.KASDemoBackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Entity
@Table(name = "Church")
@JsonRootName("church")
public class Church extends AuditModel {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long churchId = null;

    @JsonProperty("churchName")
    private String churchName;

    @JsonProperty("seniorLeader")
    private String seniorLeader;

    @Override
    public String toString() {
        return "Church{" +
                "churchId=" + churchId +
                ", churchName='" + churchName + '\'' +
                ", seniorLeader='" + seniorLeader + '\'' +
                '}';
    }
}
