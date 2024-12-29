package testTask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testTask.entity.Wallet;
import testTask.enums.OperationType;
import testTask.exception.NotEnoughFundsException;
import testTask.repository.WalletJpaRepository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletJpaRepository walletJpaRepository;
    @Override
    public Wallet getByUUID(UUID uuid) {
        return walletJpaRepository.findWalletByUuid(uuid);
    }

    @Override
    public Wallet createWallet(Wallet wallet) {
        return walletJpaRepository.save(wallet);
    }

    @Override
    public void updateWallet(UUID id, Wallet wallet) {
        Optional<Wallet> optionalWallet = walletJpaRepository.findById(id);
        Wallet updateWallet = optionalWallet.get();
        BigDecimal amountResult = updateWallet.getAmount();
        if(wallet.getAmount().compareTo(amountResult) > 0 &&
                wallet.getOperationType().equals(OperationType.WITHDRAW)){
            throw new NotEnoughFundsException("Не достаточно средств");
        }else if (wallet.getOperationType().equals(OperationType.DEPOSIT)) {
            updateWallet.setAmount(amountResult.add(wallet.getAmount()));
            updateWallet.setOperationType(wallet.getOperationType());
        } else{
            updateWallet.setAmount(amountResult.subtract(wallet.getAmount()));
            updateWallet.setOperationType(wallet.getOperationType());
        }

        walletJpaRepository.save(updateWallet);
    }
}
