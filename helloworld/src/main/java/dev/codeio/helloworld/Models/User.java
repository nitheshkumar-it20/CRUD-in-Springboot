package dev.codeio.helloworld.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="UserTable")
public class User {
    @Id
    @GeneratedValue
    Long id;
    String email;
    String password;


}
