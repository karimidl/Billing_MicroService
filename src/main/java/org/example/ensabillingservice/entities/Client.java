package org.example.ensabillingservice.entities;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {
    public int id;
    public String nom;
    public String ville;
    public String prenom;
    public int tele;
    public String email;
}
