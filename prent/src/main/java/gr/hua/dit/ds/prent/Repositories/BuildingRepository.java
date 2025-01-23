package gr.hua.dit.ds.prent.Repositories;

import gr.hua.dit.ds.prent.Entities.Ad;
import gr.hua.dit.ds.prent.Entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
}
