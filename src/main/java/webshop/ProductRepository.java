package webshop;


import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;

public class ProductRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public ProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long insertProduct(String productName, int price, int stock) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("insert into products(product_name, price, stock) values(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);){
            stmt.setString(1, productName);
            stmt.setInt(2, price);
            stmt.setInt(3, stock);

            stmt.executeUpdate();
            try(ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()){
                    return rs.getLong(1);
                }
                throw new IllegalStateException("Cannot insert and get id!");
            }

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot create product", sqle);
        }
    }

//    public Product findProductById(long id) {
//        //Product result = null; //= new Product();
//        return jdbcTemplate.queryForObject("select * from products where id = ?;", id);
//    }

    public void updateProductStock(long id, int amount) {
        //int originalAmount =  jdbcTemplate.queryForObject("select * from products where id = ?;", id);
        jdbcTemplate.update("update products set name = ? where id = ?", amount, id);
    }


}
