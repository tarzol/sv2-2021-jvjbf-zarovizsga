package webshop;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class ProductService {

    private ProductRepository productRepository;
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    public void saleProduct(long id, int amount) {
        //List<Product> products = jdbcTemplate.query("select * from products;", (rs, rowNum)-> rs.getString("product_name")));
    }
}
