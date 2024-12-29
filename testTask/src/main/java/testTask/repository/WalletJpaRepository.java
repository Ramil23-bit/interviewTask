package testTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import testTask.entity.Wallet;

import java.util.UUID;

@Repository
public interface WalletJpaRepository extends JpaRepository<Wallet, UUID> {
    @Query("select w from Wallet w WHERE w.uuid =:uuid")
    Wallet findWalletByUuid(UUID uuid);
//    @Query("select w from Wallet w where w.id =:id")
//    Optional<Wallet> findById(Long id);
}
