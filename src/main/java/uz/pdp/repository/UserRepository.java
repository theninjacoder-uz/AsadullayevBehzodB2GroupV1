package uz.pdp.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.QueryProducer;
import org.springframework.stereotype.Service;
import uz.pdp.dto.UserDto;
import uz.pdp.entity.BookEntity;
import uz.pdp.entity.UserEntity;
import uz.pdp.util.HibernateUtil;

import java.util.List;
import java.util.Optional;

@Service
public class UserRepository implements BaseRepository<UserDto, UserEntity> {

    @Override
    public Boolean add(UserDto userDto){
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            UserEntity user=new UserEntity();
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            user.setRole(4);

            session.save(user);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    public boolean isAdmin(UserDto userDto){
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "from UserEntity where username = :username and password = :password";
        Query query = session.createQuery(hql);
        query.setString("username", userDto.getUsername());
        query.setString("password", userDto.getPassword());
        query.setMaxResults(1);
        Optional optional = query.uniqueResultOptional();
        if(optional.isPresent()){
            UserEntity user =(UserEntity) optional.get();
            return (user.getRole() & 4 | user.getRole() & 8) > 0 ? true : false;
        }
        return false;
    }

    @Override
    public List<UserEntity> list() {
        return null;
    }

    @Override
    public UserEntity edite(Long id, UserDto item) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return false;
    }
}
