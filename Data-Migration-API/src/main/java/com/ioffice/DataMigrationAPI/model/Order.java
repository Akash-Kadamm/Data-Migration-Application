package com.ioffice.DataMigrationAPI.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table( name="orders")
@ToString
public class Order {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Column
    private String tShirtSize;
    @Column
    private String address;
    @OneToOne
    @JoinColumn(name=" userId")
    private User user;
}
