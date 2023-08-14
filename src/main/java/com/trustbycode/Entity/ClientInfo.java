package com.trustbycode.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Bank Client Details")
public class ClientInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Client ID")
    private Long id;

    @Column(name = "Client Name")
    private String clientName;

    @Column(name = "Routine Number")
    private String accountNumber;

    @Column(name = "Email Address")
    private String email;
}
