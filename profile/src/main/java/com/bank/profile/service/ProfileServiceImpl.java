package com.bank.profile.service;

import com.bank.profile.entity.Profile;
import com.bank.profile.repository.ProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;


    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public void save(Profile profile) {
        profile.setId(null);
        profileRepository.save(profile);
    }

    @Override
    public void update(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile findById(Long id) {
        return profileRepository.getReferenceById(id);
    }

    @Override
    public boolean existById(Long id) {
        return profileRepository.existsById(id);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Profile profile = findById(id);
        profileRepository.delete(profile);
        System.out.println("Я отработал");
    }

    @Override
    public void delete(Profile profile) {
        profileRepository.delete(profile);
    }
}
