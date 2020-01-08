package io.pivotal.pal.tracker;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;

public class JdbcTimeEntryRepository implements TimeEntryRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTimeEntryRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        long id = jdbcTemplate.queryForObject(
<<<<<<< HEAD
<<<<<<< HEAD
                "INSERT INTO time_entries (project_id, user_id, date, hours) VALUES (?, ?, ?, ?) RETURNING id",
                new Object[]{
                        timeEntry.getProjectId(),
                        timeEntry.getUserId(),
                        Date.valueOf(timeEntry.getDate()),
                        timeEntry.getHours()
                },
                Integer.class
=======
=======
>>>>>>> c1d3eb0... Persist time entries in database
            "INSERT INTO time_entries (project_id, user_id, date, hours) VALUES (?, ?, ?, ?) RETURNING id",
            new Object[]{
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                Date.valueOf(timeEntry.getDate()),
                timeEntry.getHours()
            },
            Integer.class
<<<<<<< HEAD
>>>>>>> c1d3eb0... Persist time entries in database
=======
>>>>>>> c1d3eb0... Persist time entries in database
        );

        return find(id);
    }

    @Override
    public TimeEntry find(Long id) {
        return jdbcTemplate.query(
<<<<<<< HEAD
<<<<<<< HEAD
                "SELECT id, project_id, user_id, date, hours FROM time_entries WHERE id = ?",
                new Object[]{id},
                extractor);
=======
            "SELECT id, project_id, user_id, date, hours FROM time_entries WHERE id = ?",
            new Object[]{id},
            extractor);
>>>>>>> c1d3eb0... Persist time entries in database
=======
            "SELECT id, project_id, user_id, date, hours FROM time_entries WHERE id = ?",
            new Object[]{id},
            extractor);
>>>>>>> c1d3eb0... Persist time entries in database
    }

    @Override
    public List<TimeEntry> list() {
        return jdbcTemplate.query("SELECT id, project_id, user_id, date, hours FROM time_entries ORDER BY id", mapper);
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        jdbcTemplate.update("UPDATE time_entries " +
<<<<<<< HEAD
<<<<<<< HEAD
                        "SET project_id = ?, user_id = ?, date = ?,  hours = ? " +
                        "WHERE id = ?",
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                Date.valueOf(timeEntry.getDate()),
                timeEntry.getHours(),
                id);
=======
=======
>>>>>>> c1d3eb0... Persist time entries in database
                "SET project_id = ?, user_id = ?, date = ?,  hours = ? " +
                "WHERE id = ?",
            timeEntry.getProjectId(),
            timeEntry.getUserId(),
            Date.valueOf(timeEntry.getDate()),
            timeEntry.getHours(),
            id);
<<<<<<< HEAD
>>>>>>> c1d3eb0... Persist time entries in database
=======
>>>>>>> c1d3eb0... Persist time entries in database

        return find(id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM time_entries WHERE id = ?", id);
    }

    private final RowMapper<TimeEntry> mapper = (rs, rowNum) -> new TimeEntry(
<<<<<<< HEAD
<<<<<<< HEAD
            rs.getLong("id"),
            rs.getLong("project_id"),
            rs.getLong("user_id"),
            rs.getDate("date").toLocalDate(),
            rs.getInt("hours")
    );

    private final ResultSetExtractor<TimeEntry> extractor =
            (rs) -> rs.next() ? mapper.mapRow(rs, 1) : null;
}
=======
=======
>>>>>>> c1d3eb0... Persist time entries in database
        rs.getLong("id"),
        rs.getLong("project_id"),
        rs.getLong("user_id"),
        rs.getDate("date").toLocalDate(),
        rs.getInt("hours")
    );

    private final ResultSetExtractor<TimeEntry> extractor =
        (rs) -> rs.next() ? mapper.mapRow(rs, 1) : null;
}
<<<<<<< HEAD
>>>>>>> c1d3eb0... Persist time entries in database
=======
>>>>>>> c1d3eb0... Persist time entries in database
