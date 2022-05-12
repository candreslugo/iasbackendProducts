package com.ias.backendProducts.infrastructure.adapters.out;

import com.ias.backendProducts.products.application.domain.Product;
import com.ias.backendProducts.products.application.domain.ProductId;
import com.ias.backendProducts.products.application.models.ProductDBO;
import com.ias.backendProducts.products.application.ports.out.ProductRepository;
import com.ias.backendProducts.shared.sharedDomain.PageQuery;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Repository
public class SqlProductsRepository implements ProductRepository {

    private final DataSource dataSource;

    public SqlProductsRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void store(Product product) {
        String sql = "INSERT INTO products (id, name, type_of_product, price) VALUES (?, ?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, product.getProductId().getValue());
            preparedStatement.setString(2, product.getName().toString());
            preparedStatement.setInt(3, product.getTypeOfProduct().getValue());
            preparedStatement.setLong(4, product.getPrice().getValue());

            preparedStatement.execute();

        } catch (SQLException exception) {
            throw new RuntimeException("Error querying database", exception);
        }
    }

    @Override
    public Optional<Product> get(ProductId productId) {
        String sql = "Select * From products Where id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, productId.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ProductDBO productDBO = ProductDBO.fromResultSet(resultSet);
                Product product = productDBO.toDomain();
                return Optional.of(product);
            } else {
                return Optional.empty();
            }
        }catch (SQLException exception) {
            throw new RuntimeException("Error querying database", exception);
        }
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE product SET start = ?, finish = ?, description = ? WHERE service_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, product.getProductId().getValue());
            preparedStatement.setString(2, product.getName().toString());
            preparedStatement.setInt(3, product.getTypeOfProduct().getValue());
            preparedStatement.setLong(4, product.getPrice().getValue());

            preparedStatement.execute();
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Error querying database", exception);
        }
    }

    @Override
    public void delete(ProductId productId) {

    }

    @Override
    public List<Product> getProducts(PageQuery pageQuery) {
        return null;
    }


}
