package com.bank.profile.controllers;

import com.bank.profile.dto.PassportDto;
import com.bank.profile.dto.ProfileDto;
import com.bank.profile.entity.Passport;
import com.bank.profile.entity.Profile;
import com.bank.profile.mapper.ProfileMapper;
import com.bank.profile.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile/")
public class ProfileController {

    private final ProfileService profileService;
    private final ProfileMapper profileMapper;

    public ProfileController(ProfileService profileService, ProfileMapper profileMapper) {
        this.profileService = profileService;
        this.profileMapper = profileMapper;
    }


    @GetMapping("list")
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileService.findAll();
        return ResponseEntity.ok(profiles);
    }


    @GetMapping("{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable Long id) {
        Profile profile = profileService.getById(id);
        return ResponseEntity.ok(profile);
    }

    @PostMapping("create")
    public ResponseEntity<Profile> createProfile(@RequestBody ProfileDto profileDto) {
        Profile profile = profileService.save(profileDto);
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<Profile> updatePassport(@RequestBody ProfileDto profileDto, @PathVariable Long id) {
        Profile profile = profileService.update(profileDto, id);
        return ResponseEntity.ok(profile);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Profile> deleteUser(@PathVariable Long id) {
        Profile profile = profileService.getById(id);
        profileService.delete(profile);
        return ResponseEntity.ok().build();
    }
}
