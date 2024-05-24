package ir.group3.drugstoreDemo.repository;

import ir.group3.drugstoreDemo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
