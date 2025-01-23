package gr.hua.dit.ds.prent.Services;

import gr.hua.dit.ds.prent.Entities.Ad;
import gr.hua.dit.ds.prent.Entities.Property;
import gr.hua.dit.ds.prent.Repositories.AdRepository;
import gr.hua.dit.ds.prent.Repositories.PropertyRepository;
import io.jsonwebtoken.lang.Collections;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class AdService {
    private AdRepository adRepository;

    private PropertyRepository propertyRepository;

    public AdService(AdRepository adRepository,
                     PropertyRepository propertyRepository) {
        this.adRepository = adRepository;
        this.propertyRepository = propertyRepository;
    }

    @Transactional
    public List<Ad> getAd(){
        return adRepository.findAll();
    }

    @Transactional
    public Ad saveAd(Ad ad) {
        return adRepository.save(ad);
    }

    @Transactional
    public Optional<Ad> getAd(Long adId) {
        return adRepository.findById(adId);
    }
    @Transactional
    public void assignPropertyToAd(Long adId, Property property) {
        Ad ad = adRepository.findById(adId).get();
        System.out.println(ad);
        System.out.println(ad.getProperty());
        ad.setProperty(property);
        System.out.println(ad.getProperty());
        adRepository.save(ad);
    }

    public boolean deleteAd(Long adId) {
        Optional<Ad> ad = adRepository.findById(adId);

        if (ad.isPresent()) {
            adRepository.deleteById(adId);
            return true;
        }
        else {
            return false;
        }

    }
}
