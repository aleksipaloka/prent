package gr.hua.dit.ds.prent.Services;

import gr.hua.dit.ds.prent.Entities.User;
import gr.hua.dit.ds.prent.Entities.Property;
import gr.hua.dit.ds.prent.Repositories.UserRepository;
import gr.hua.dit.ds.prent.Repositories.PropertyRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class PropertyService {

    private PropertyRepository propertyRepository;

    private UserRepository ownerRepository;

    public PropertyService(PropertyRepository propertyRepository,
                           UserRepository ownerRepository) {
        this.propertyRepository = propertyRepository;
        this.ownerRepository = ownerRepository;
    }

    @Transactional
    public List<Property> getProperty(){
        return propertyRepository.findAll();
    }

    @Transactional
    public Property saveProperty(Property property) {
        return propertyRepository.save(property);
    }

    @Transactional
    public Optional<Property> getProperty(Long propertyId) {
        return propertyRepository.findById(propertyId);
    }
    @Transactional
    public void assignPersonToProperty(Long propertyId, User owner) {
        Property property = propertyRepository.findById(propertyId).get();
        System.out.println(property);
        System.out.println(property.getOwner());
        property.setOwner(owner);
        System.out.println(property.getOwner());
        propertyRepository.save(property);
    }

    public boolean deleteAd(Long buildingId) {
        Optional<Property> building = propertyRepository.findById(buildingId);

        if (building.isPresent()) {
            propertyRepository.deleteById(buildingId);
            return true;
        }
        else {
            return false;
        }

    }
}
