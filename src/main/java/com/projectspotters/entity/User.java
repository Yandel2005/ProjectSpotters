package com.projectspotters.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

//Declare this class an entity table
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserPreference preference;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "passhash", nullable = false)
    private String passHash;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public User() {
    }

    public User(String username, String email, String passHash) {
        this.username = username;
        this.email = email;
        this.passHash = passHash;
    }

    public UserPreference getPreference(){
        return preference;
    }

    public void setPreference(UserPreference preference){
        this.preference = preference;
        if (preference != null) {
            preference.setUser(this);
        }
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

}
