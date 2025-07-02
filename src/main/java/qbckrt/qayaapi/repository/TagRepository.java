package qbckrt.qayaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qbckrt.qayaapi.entity.Tag;

import java.util.UUID;

@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {
}
