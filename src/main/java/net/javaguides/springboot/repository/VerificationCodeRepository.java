package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Long> {
    VerificationCode findByCode(String code);
    VerificationCode findByLogin_Id(Long loginId);
}