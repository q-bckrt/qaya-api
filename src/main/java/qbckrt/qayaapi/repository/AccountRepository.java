package qbckrt.qayaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import qbckrt.qayaapi.entity.Account;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}