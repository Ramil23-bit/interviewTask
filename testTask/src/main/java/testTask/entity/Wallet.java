package testTask.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import testTask.enums.OperationType;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "wallet")
public class Wallet {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Enumerated(EnumType.STRING)
    private OperationType operationType;

    private BigDecimal amount;

}
