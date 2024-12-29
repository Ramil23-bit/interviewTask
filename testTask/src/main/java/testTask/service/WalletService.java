package testTask.service;

import testTask.entity.Wallet;

import java.util.List;
import java.util.UUID;

public interface WalletService {

    List<Wallet> getAll();

    Wallet getByUUID(UUID uuid);

    Wallet createWallet(Wallet wallet);

    void updateWallet(UUID id, Wallet wallet);
}
