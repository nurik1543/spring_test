package nursultan.taalaibekov.spring_test.dao;

import nursultan.taalaibekov.spring_test.Entities.City;
import nursultan.taalaibekov.spring_test.Entities.Region;
import nursultan.taalaibekov.spring_test.interfaces.IDAORegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class RegionDAOImpl implements IDAORegion {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Region region) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("insert into region(name) VALUES(?)");
            ps.setString(1, region.getName());
            return ps;
        }, keyHolder);

        System.out.println("keyHolder.getKey() = " + keyHolder.getKey());

        return (int) keyHolder.getKey();
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(Region region) {

    }

    @Override
    public void upsert(Region region) {

    }

    @Override
    public City getElementById(int id) {
        return null;
    }

    @Override
    public List<Region> getAllElemtents() {
        return null;
    }
}
