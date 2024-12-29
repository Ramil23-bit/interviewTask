package testTask.controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.transaction.annotation.Transactional;
import testTask.entity.Wallet;
import testTask.enums.OperationType;
import testTask.repository.WalletJpaRepository;
import testTask.service.WalletService;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class WalletControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WalletService walletService;

    @Autowired
    private WalletJpaRepository walletJpaRepository;

    @BeforeEach
    public void setUp() {
        Wallet wallet = new Wallet();
        wallet.setUuid(UUID.fromString("9812c448-8734-4fi5-0012-6723de6f6401"));
        wallet.setOperationType(OperationType.DEPOSIT);
        wallet.setAmount(new BigDecimal("7564.45"));
        walletService.createWallet(wallet);
    }

    @AfterEach
    public void deleteDb(){
        walletJpaRepository.deleteAll();
    }

}
