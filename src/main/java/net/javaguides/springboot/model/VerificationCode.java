package net.javaguides.springboot.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.Calendar;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
public class VerificationCode {

    private static final int EXPIRATION = 60 * 24; 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    @OneToOne(targetEntity = Login.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "login_id")
    private Login login;

    private Date expiryDate;

    public VerificationCode(String code, Login login) {
        this.code = code;
        this.login = login;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }
}