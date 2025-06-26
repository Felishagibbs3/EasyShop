package org.yearup.data.mysql;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao
{
    private final JdbcTemplate jdbcTemplate;
    public MySqlCategoryDao(DataSource dataSource, JdbcTemplate jdbcTemplate)
    {
        super(dataSource);
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Category> getAllCategories()
    {
        String sql = "SELECT * FROM categories";
        // get all categories
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class));
    }

    @Override
    public Category getById(int categoryId)
    {
        String sqlId = "SELECT * FROM categories WHERE category_id = ?";
        // get category by id
        return jdbcTemplate.queryForObject(sqlId, new BeanPropertyRowMapper<>(Category.class), categoryId);
    }

    @Override
    public Category create(Category category)
    {
        String sqlCreate = "INSERT INTO categories (name, description) VALUES (?, ?)";

        jdbcTemplate.update(sqlCreate, category.getName(), category.getDescription());
        // create a new category
        return new Category(0, category.getName(), category.getDescription());
    }

    @Override
    public void update(int categoryId, Category category)
    {
        String sqlUpdate = "UPDATE categories SET name = ?, description = ? WHERE category_id = ?";
        jdbcTemplate.update(sqlUpdate, category.getName(), category.getDescription(), categoryId);
        // update category
    }

    @Override
    public void delete(int categoryId)
    {
        String sqlDelete = "DELETE FROM categories WHERE category_id = ?";
        jdbcTemplate.update(sqlDelete, categoryId);
        // delete category
    }

    private Category mapRow(ResultSet row) throws SQLException
    {
        int categoryId = row.getInt("category_id");
        String name = row.getString("name");
        String description = row.getString("description");

        Category category = new Category()
        {{
            setCategoryId(categoryId);
            setName(name);
            setDescription(description);
        }};

        return category;
    }

}
