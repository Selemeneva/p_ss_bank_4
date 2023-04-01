package com.bank.profile.service;

import com.bank.profile.entity.Audit;
import com.bank.profile.repository.AuditRepository;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImpl implements AuditService {
    private final AuditRepository auditRepository;

    public AuditServiceImpl(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Override
    public void save(Audit audit) {
        auditRepository.save(audit);
    }
}
