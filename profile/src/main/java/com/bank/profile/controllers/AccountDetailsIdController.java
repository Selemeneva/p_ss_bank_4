package com.bank.profile.controllers;

import com.bank.profile.dto.AccountDetailsIdDto;
import com.bank.profile.entity.AccountDetailsId;
import com.bank.profile.service.AccountDetailsIdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account_details_id/")
public class AccountDetailsIdController {
    private final AccountDetailsIdService accountDetailsIdService;

    public AccountDetailsIdController(AccountDetailsIdService accountDetailsIdService) {
        this.accountDetailsIdService = accountDetailsIdService;
    }

    @GetMapping("list")
    public ResponseEntity<List<AccountDetailsId>> getAllAccountDetailsId() {
        List<AccountDetailsId> accountDetailsIds = accountDetailsIdService.findAll();
        return ResponseEntity.ok(accountDetailsIds);
    }
    @GetMapping("{id}")
    public ResponseEntity<AccountDetailsId> getAccountDetailsId(@PathVariable long id) {
        AccountDetailsId accountDetailsId = accountDetailsIdService.getById(id);
        return ResponseEntity.ok(accountDetailsId);
    }
    @PostMapping("create")
    public ResponseEntity<AccountDetailsId> createAccountDetailsId(@RequestBody AccountDetailsIdDto accountDetailsIdDto) {
        AccountDetailsId accountDetailsId = accountDetailsIdService.save(accountDetailsIdDto);
        return new ResponseEntity<>(accountDetailsId, HttpStatus.CREATED);
    }
    @PatchMapping("update/{id}")
    public ResponseEntity<AccountDetailsId> updateAccountDetailsId(@RequestBody AccountDetailsIdDto accountDetailsIdDto, @PathVariable Long id) {
        AccountDetailsId accountDetailsId = accountDetailsIdService.update(accountDetailsIdDto, id);
        return new ResponseEntity<>(accountDetailsId, HttpStatus.CREATED);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<AccountDetailsId> createAccountDetailsId(@PathVariable Long id) {
        AccountDetailsId accountDetailsId = accountDetailsIdService.getById(id);
        accountDetailsIdService.delete(accountDetailsId);
        return ResponseEntity.ok().build();
    }
}
