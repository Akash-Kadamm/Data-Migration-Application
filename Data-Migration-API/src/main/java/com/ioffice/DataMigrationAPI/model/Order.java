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
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Column(name = "t_shirt_size")
    private String tShirtSize;
    @Column(name = "address")
    private String address;
    @OneToOne
    @JoinColumn(name=" userId")
    private User user;
}
