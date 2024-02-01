package com.robotapplication.jar.Survivor.Repositories;

import com.robotapplication.jar.Survivor.Entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
