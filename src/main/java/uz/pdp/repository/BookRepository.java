package uz.pdp.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import uz.pdp.dto.BookDto;
import uz.pdp.dto.UserDto;
import uz.pdp.entity.BookEntity;
import uz.pdp.util.HibernateUtil;

import java.util.List;

public class BookRepository implements BaseRepository<BookDto, BookEntity> {

    @Override
    public Boolean add(BookDto bookDto){
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            BookEntity book=new BookEntity();
            book.setTitle(bookDto.getTitle());
            book.setAuthor(bookDto.getAuthor());
            book.setPrice(bookDto.getPrice());

            session.save(book);
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

    @Override
    public List<BookEntity> list(){
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from BookEntity");
        List<BookEntity> books =  query.list();
        session.close();
        return books;
    }

    @Override
    public BookEntity edite(Long id, BookDto b){

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "update BookEntity set title = :title, author=:author,price=:price where id = :id";

        Query query = session.createQuery(hql);
        if (query == null)
            return new BookEntity();

        query.setLong("id", id);
        query.setString("title",b.getTitle());
        query.setString("author",b.getAuthor());
        query.setDouble("price",b.getPrice());
        query.executeUpdate();

        tx.commit();
        session.close();
        return new BookEntity(id, b.getTitle(), b.getAuthor(), b.getPrice());
    }

    @Override
    public Boolean delete(Long id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from BookEntity where id = :id";
        Query query = session.createQuery(hql);
        query.setLong("id",id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount > 0 ? true : false;
    }


}
