package com.example.SrpingJDBCProject.repo;

import com.example.SrpingJDBCProject.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Repository
public class AlienRepo {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate(){
        return  jdbcTemplate;
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public void save(Alien alien){

        String sql = "insert into alien(id, name, tech) values (?, ?, ?) ";

        int rows = jdbcTemplate.update(sql, alien.getId(), alien.getName(), alien.getTech());
        System.out.println("Rows effected :" + rows);

        System.out.println("Data Saved");
    }

    public List<Alien> getAliens(){
        String sql = "select * from alien";

        RowMapper<Alien> rowMapper = new RowMapper<Alien>() {

            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
                Alien alien = new Alien();

                alien.setId(rs.getInt(1));
                alien.setName(rs.getString(2));
                alien.setTech(rs.getString(3));

                return alien;
            }
        };

       List<Alien> alienList =  jdbcTemplate.query(sql, rowMapper);
       return alienList;
    }
}
