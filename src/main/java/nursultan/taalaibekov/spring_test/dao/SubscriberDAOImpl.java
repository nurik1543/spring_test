package nursultan.taalaibekov.spring_test.dao;

import nursultan.taalaibekov.spring_test.Entities.Subscriber;
import nursultan.taalaibekov.spring_test.interfaces.IDAOSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class SubscriberDAOImpl implements IDAOSubscriber {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Subscriber subscriber) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.
                    prepareStatement("insert into subscriber(name, surname, phone, city_id, region_id) VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, subscriber.getName());
            ps.setString(2, subscriber.getSurname());
            ps.setString(3, subscriber.getPhone());
            ps.setInt(4, subscriber.getCityId());
            ps.setInt(5, subscriber.getRegionId());
            return ps;
        }, keyHolder);

        System.out.println("keyHolder.getKey() = " + keyHolder.getKey());

        return (int) keyHolder.getKey();
    }

    @Override
    public int update(Subscriber subscriber) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.
                    prepareStatement("update subscriber set name = ?," +
                            " surname = ?," +
                            " phone = ?," +
                            " city_id = ?," +
                            " region_id = ?" +
                            " where id = ?");
            ps.setString(1, subscriber.getName());
            ps.setString(2, subscriber.getSurname());
            ps.setString(3, subscriber.getPhone());
            ps.setInt(4, subscriber.getCityId());
            ps.setInt(5, subscriber.getRegionId());
            ps.setInt(6, subscriber.getId());
            return ps;
        }, keyHolder);

        System.out.println("keyHolder.getKey() = " + keyHolder.getKey());

        return subscriber.getId();
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void upsert(Subscriber subscriber) {

    }

    @Override
    public Subscriber getElementById(int id) {
        return jdbcTemplate.queryForObject("select * from subscriber where id=?",
                new Object[] {id},
                new SubscriberDAOImpl.SubscriberRowMapper());
    }

    @Override
    public List<Subscriber> getAllElemtents() {
        return null;
    }

    private static final class SubscriberRowMapper implements RowMapper<Subscriber> {
        @Override
        public Subscriber mapRow(ResultSet rs, int rowNum) throws SQLException {
            Subscriber sub = new Subscriber();
            sub.setId(rs.getInt("id"));
            sub.setName(rs.getString("name"));
            sub.setSurname(rs.getString("surname"));
            sub.setPhone(rs.getString("phone"));
            sub.setCityId(rs.getInt("city_id"));
            sub.setRegionId(rs.getInt("region_id"));
            return sub;
        }
    }
}
