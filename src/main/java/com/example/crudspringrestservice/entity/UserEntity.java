package com.example.crudspringrestservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    //какой столбец в таблице Users имеет FK
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    // @JsonBackReference
    private AddressEntity address;
}
