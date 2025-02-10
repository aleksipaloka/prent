package gr.hua.dit.ds.prent.Services;

import gr.hua.dit.ds.prent.Entities.Property;
import gr.hua.dit.ds.prent.Entities.RentApplications;
import gr.hua.dit.ds.prent.Entities.User;
import gr.hua.dit.ds.prent.Repositories.AdRepository;
import gr.hua.dit.ds.prent.Repositories.PropertyRepository;
import gr.hua.dit.ds.prent.Repositories.RentApplicationsRepository;
import gr.hua.dit.ds.prent.Repositories.UserRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class RentApplicationsService {

    private RentApplicationsRepository rentApplicationsRepository;

    private AdRepository adRepository;

    private UserRepository ownerRepository;

    public RentApplicationsService(RentApplicationsRepository rentApplicationsRepository, AdRepository adRepository,
                           UserRepository ownerRepository) {
        this.rentApplicationsRepository = rentApplicationsRepository;
        this.adRepository = adRepository;
        this.ownerRepository = ownerRepository;
    }

    @Transactional
    public List<RentApplications> getRentApplications(){
        return rentApplicationsRepository.findAll();
    }

    @Transactional
    public RentApplications saveRentApplications(RentApplications rentApplication) {
        return rentApplicationsRepository.save(rentApplication);
    }

    @Transactional
    public Optional<RentApplications> getRentApplications(Long RentApplicationsId) {
        return rentApplicationsRepository.findById(RentApplicationsId);
    }

    public boolean deleteRentApplication(Long rentApplicationId) {
        Optional<RentApplications> rentApplication = rentApplicationsRepository.findById(rentApplicationId);

        if (rentApplication.isPresent()) {
            rentApplicationsRepository.deleteById(rentApplicationId);
            return true;
        }
        else {
            return false;
        }

    }
}
