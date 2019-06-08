package nursultan.taalaibekov.spring_test.dao;

import nursultan.taalaibekov.spring_test.Entities.City;
import nursultan.taalaibekov.spring_test.interfaces.IDAOCity;
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
public class CityDAOImpl implements IDAOCity {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(City city) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("insert into city(name) VALUES(?)");
            ps.setString(1, city.getName());
            return ps;
        }, keyHolder);

        System.out.println("keyHolder.getKey() = " + keyHolder.getKey());

        return (int) keyHolder.getKey();
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(City city) {

    }

    @Override
    public void upsert(City city) {

    }

    @Override
    public City getElementById(int id) {
        return jdbcTemplate.queryForObject("select * from city where id=?",
                new Object[] {id},
                new CityDAOImpl.CityRowMapper());
    }

    @Override
    public List<City> getAllElemtents() {
        return null;
    }

    private static final class CityRowMapper implements RowMapper<City> {
        @Override
        public City mapRow(ResultSet rs, int rowNum) throws SQLException {
            City city = new City();
            city.setId(rs.getInt("id"));
            city.setName(rs.getString("name"));
            return city;
        }
    }

}
