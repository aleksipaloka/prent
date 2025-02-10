package gr.hua.dit.ds.prent.Repositories;

import gr.hua.dit.ds.prent.Entities.RentApplications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentApplicationsRepository extends JpaRepository<RentApplications, Long> {
}
