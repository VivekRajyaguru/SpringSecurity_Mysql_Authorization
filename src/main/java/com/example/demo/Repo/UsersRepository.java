package example.demo.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import example.demo.VO.User;

public interface UsersRepository extends JpaRepository<User, Long>{
	Optional<User> findByName(String userName);
	
}
