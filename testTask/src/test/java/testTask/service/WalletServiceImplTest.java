package testTask.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import testTask.entity.Wallet;
import testTask.exception.EnteredNotCompletedDataException;
import testTask.exception.NotFoundWallet;
import testTask.repository.WalletJpaRepository;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WalletServiceImplTest {
    @Mock
    private WalletJpaRepository walletJpaRepository;

    @InjectMocks
    private WalletServiceImpl walletService;

    @Test
    public void getByMessageWhenUuidNotFound(){
        UUID uuid = UUID.randomUUID();

        when(walletJpaRepository.findWalletByUuid(uuid))
                .thenThrow(new NotFoundWallet("Wallet not found"));
        Assertions.assertThrows(NotFoundWallet.class,
                ()-> walletService.getByUUID(uuid));
    }

    @Test
    public void getByUuidWhenUuidContainsInDataBase(){
        UUID uuid = UUID.fromString("c7748c60-1d7c-4ce1-a301-ca23eb80a642");
        Wallet walletExpected = new Wallet();
        walletExpected.setUuid(uuid);

        when(walletJpaRepository.findWalletByUuid(uuid))
                .thenReturn(walletExpected);
        Wallet walletActual = walletService.getByUUID(uuid);
        Assertions.assertEquals(walletExpected, walletActual);
    }

    @Test
    public void getByMessageWhenEnteredNotCompletedData(){
        Wallet wallet = new Wallet();
        wallet.setAmount(BigDecimal.valueOf(1243));

        when(walletJpaRepository.save(wallet))
                .thenThrow(new EnteredNotCompletedDataException("Entered not completed Data"));

        Assertions.assertThrows(EnteredNotCompletedDataException.class,
                ()->walletService.createWallet(wallet));
    }
}
