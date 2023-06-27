package sg.edu.nus.iss.paf_day24workshop_jul2023.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDetailsRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String insertSQL = "insert into order_details (product, unit_price, discount, quantity, order_id) values (?, ?, ?, ?, ?)";
    
}

