package gr.hua.dit.ds.prent.Repositories;

import gr.hua.dit.ds.prent.Entities.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
}
