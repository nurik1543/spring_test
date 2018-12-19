package nursultan.taalaibekov.spring_test.dao;


import nursultan.taalaibekov.spring_test.Entities.RoutineTemplate;
import nursultan.taalaibekov.spring_test.interfaces.IDAOTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Component("templateDAOImpl")
public class TemplateDAOImpl implements IDAOTemplate {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void upsert(RoutineTemplate routineTemplate) {
        if(routineTemplate.getId() <= 0) {
            insert(routineTemplate);
        } else {
            update(routineTemplate);
        }
    }

    @Override
    public void update(RoutineTemplate template) {
        jdbcTemplate.update("update templates set name = ?, description = ? where id = ?",
                template.getName(), template.getDescription(), template.getId());
    }

    @Override
    public void insert(RoutineTemplate template) {
        jdbcTemplate.update("insert into templates (name, description) VALUES (?, ?)",
                template.getName(), template.getDescription());
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("delete from templates where id=?", id);
    }

    @Override
    public RoutineTemplate getElementById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return jdbcTemplate.queryForObject("select * from templates where id=?",
                                            new Object[] {id},
                                            new RoutineTemplateRowMapper());
    }

    @Override
    public List<RoutineTemplate> getAllElemtents() {
        return jdbcTemplate.query("select * from TEMPLATES",
                                    new RoutineTemplateRowMapper());
    }

    private static final class RoutineTemplateRowMapper implements RowMapper<RoutineTemplate> {
        @Override
        public RoutineTemplate mapRow(ResultSet rs, int rowNum) throws SQLException {
            RoutineTemplate template = new RoutineTemplate();
            template.setId(rs.getInt("id"));
            template.setName(rs.getString("name"));
            template.setDescription(rs.getString("description"));
            return template;
        }
    }
}
