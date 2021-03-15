package com.example.testjpa.account;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
//@Table(name = "persistent_logins")
public class PersistentLogins {

    @Id
    private String username;
    private String series;
    private String token;
//    @Column(name = "last_used")
    private LocalDateTime lastUsed;
}
