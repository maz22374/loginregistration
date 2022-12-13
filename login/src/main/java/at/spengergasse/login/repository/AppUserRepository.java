package at.spengergasse.login.repository;

import at.spengergasse.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author david on 08.12.2022
 * @version 1.0.0
 */
@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User a " + "SET a.isEnabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);
}
