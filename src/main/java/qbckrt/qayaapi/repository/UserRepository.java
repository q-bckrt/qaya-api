package qbckrt.qayaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import qbckrt.qayaapi.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
