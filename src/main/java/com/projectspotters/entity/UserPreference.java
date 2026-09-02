package com.projectspotters.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_preference")
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_pref_id")
    private Long userPrefId;

    @Column(name = "user_goal", nullable = false, unique = false)
    private String userGoal;

    @Column(name = "user_discipline", nullable = false, unique = false)
    private String userDiscipline;

    @Column(name = "experience_level", nullable = false, unique = false)
    private String experienceLevel;

    @Column(name = "is_experience_public", nullable = false, unique = false)
    private boolean isExperiencePublic;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, unique = true)
    private User user;

    public UserPreference() {
    }

    public UserPreference(String userGoal, String userDiscipline, String experienceLevel, boolean isExperiencePublic) {
    this.userGoal = userGoal;
    this.userDiscipline = userDiscipline;
    this.experienceLevel = experienceLevel;
    this.isExperiencePublic = isExperiencePublic;

    }

    public Long getUserPrefId() {
        return userPrefId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserGoal() {
        return userGoal;
    }

    public void setUserGoal(String userGoal) {
        this.userGoal = userGoal;
    }

    public String getUserDiscipline() {
        return userDiscipline;
    }

    public void setUserDiscipline(String userDiscipline) {
        this.userDiscipline = userDiscipline;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public boolean isExperiencePublic() {
        return isExperiencePublic;
    }

    public void setExperiencePublic(boolean experiencePublic) {
        isExperiencePublic = experiencePublic;
    }
}



