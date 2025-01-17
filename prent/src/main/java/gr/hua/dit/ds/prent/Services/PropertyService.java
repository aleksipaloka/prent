package gr.hua.dit.ds.prent.Services;

import gr.hua.dit.ds.prent.Entities.Building;
import gr.hua.dit.ds.prent.Entities.Person;
import gr.hua.dit.ds.prent.Entities.Property;
import gr.hua.dit.ds.prent.Repositories.BuildingRepository;
import gr.hua.dit.ds.prent.Repositories.PersonRepository;
import gr.hua.dit.ds.prent.Repositories.PropertyRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class PropertyService {

    private PropertyRepository propertyRepository;

    private PersonRepository ownerRepository;

    public PropertyService(PropertyRepository propertyRepository,
                           PersonRepository ownerRepository) {
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
    public Optional<Property> getProperty(Integer propertyId) {
        return propertyRepository.findById(propertyId);
    }
    @Transactional
    public void assignPersonToProperty(int propertyId, Person owner) {
        Property property = propertyRepository.findById(propertyId).get();
        System.out.println(property);
        System.out.println(property.getOwner());
        property.setOwner(owner);
        System.out.println(property.getOwner());
        propertyRepository.save(property);
    }

    public boolean deleteAd(Integer buildingId) {
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
