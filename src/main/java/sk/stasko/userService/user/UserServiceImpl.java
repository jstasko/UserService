package sk.stasko.userService.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDaoImpl dao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = dao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findByEmail(String email) {
        return this.userDao.findDoctorByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User applicationUser = userDao.findDoctorByUsername(username);
        if (applicationUser == null) {
            logger.trace("User is not found");
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User
                (applicationUser.getUsername(), applicationUser.getPassword(), emptyList());

    }

    @Override
    public User signUp(User user) {
        logger.info("Password is being encoded");
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        return this.userDao.save(user);
    }
}
