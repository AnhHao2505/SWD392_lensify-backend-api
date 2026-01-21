package swd_sentify.back_end.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swd_sentify.back_end.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByUserIdAndActive(Long userid, boolean active);
    Optional<User> findByVerificationCode(String verificationCode);
}
