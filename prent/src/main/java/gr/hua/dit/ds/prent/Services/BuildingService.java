package gr.hua.dit.ds.prent.Services;

import gr.hua.dit.ds.prent.Entities.Ad;
import gr.hua.dit.ds.prent.Entities.Building;
import gr.hua.dit.ds.prent.Entities.Property;
import gr.hua.dit.ds.prent.Repositories.AdRepository;
import gr.hua.dit.ds.prent.Repositories.BuildingRepository;
import gr.hua.dit.ds.prent.Repositories.PropertyRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class BuildingService {

    private BuildingRepository buildingRepository;

    private PropertyRepository propertyRepository;

    public BuildingService(BuildingRepository buildingRepository,
                     PropertyRepository propertyRepository) {
        this.buildingRepository = buildingRepository;
        this.propertyRepository = propertyRepository;
    }

    @Transactional
    public List<Building> getBuilding(){
        return buildingRepository.findAll();
    }

    @Transactional
    public Building saveBuilding(Building building) {
        return buildingRepository.save(building);
    }

    @Transactional
    public Optional<Building> getBuilding(Long buildingId) {
        return buildingRepository.findById(buildingId);
    }
    @Transactional
    public void assignPropertyToAd(Long buildingId, Property property) {
        Building building = buildingRepository.findById(buildingId).get();
        System.out.println(building);
        System.out.println(building.getProperty());
        building.setProperty(property);
        System.out.println(building.getProperty());
        buildingRepository.save(building);
    }

    public boolean deleteAd(Long buildingId) {
        Optional<Building> building = buildingRepository.findById(buildingId);

        if (building.isPresent()) {
            buildingRepository.deleteById(buildingId);
            return true;
        }
        else {
            return false;
        }

    }
}
