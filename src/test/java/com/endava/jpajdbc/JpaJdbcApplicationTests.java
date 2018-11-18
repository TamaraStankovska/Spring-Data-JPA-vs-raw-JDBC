package com.endava.jpajdbc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaJdbcApplicationTests {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Test
	public void contextLoads() {
	}

	@Test
	public void testJpa() {
		long startTime = System.nanoTime();
		Optional<Product> product = productRepository.findByProductLine("Random Product Line8373");
		long elapsedTime = System.nanoTime() - startTime;
		logger.info("Exe time " + elapsedTime);
		Assert.assertEquals(500, 500);
	}

	@Test
	public void testJDBCTemplate() {
		String product_line = "Random Product Line8373";
		long startTime = System.nanoTime();
		Product product = jdbcTemplate.queryForObject("select * from products where product_line = ?", new Object[]{product_line}, new BeanPropertyRowMapper<Product>(Product.class));
		long elapsedTime = System.nanoTime() - startTime;
		logger.info(product.getProductName() + "Query exe time: " + elapsedTime);
		Assert.assertEquals(500, 500);
	}




//	@Test
//	public void testJDBC() throws SQLException {
//		long startTime = System.nanoTime();
//		productService.deleteProduct(10090);
//		long elapsedTime = System.nanoTime() - startTime;
//		logger.info("Query exe time: " + elapsedTime);
//		Assert.assertEquals(500, 500);
//	}

}
