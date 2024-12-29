package testTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testTask.entity.Wallet;
import testTask.service.WalletService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping("/all/wallet")
    public List<Wallet> getAll(){
        return walletService.getAll();
    }
    @GetMapping("/wallet/{uuid}")
    public Wallet getWalletByUUID(@PathVariable("uuid") UUID uuid){
        return walletService.getByUUID(uuid);
    }

    @PostMapping("/wallet")
    public Wallet createWallet(@RequestBody Wallet wallet){
        return walletService.createWallet(wallet);
    }

    @PutMapping("/update_wallet/{id}")
    public void update(@PathVariable(name = "id") UUID id, @RequestBody Wallet wallet){
        walletService.updateWallet(id, wallet);
    }
}
