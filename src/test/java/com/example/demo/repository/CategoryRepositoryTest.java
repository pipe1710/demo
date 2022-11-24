package com.example.demo.repository;

import com.example.demo.category.entity.Category;
import com.example.demo.category.repository.CategoryRepository;
import com.example.demo.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = true)
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void should_find_no_tutorials_if_categories_is_empty() {
        List<Category> categories = categoryRepository.findAll();

        assertThat(categories).isEmpty();
    }

    @Test
    void should_store_a_category() {
        Category category1 = new Category();
        category1.setCategoryName("Category1");
        category1.setCategoryDescription("Decription1");

        Category category = categoryRepository.save(category1);

        assertThat(category).hasFieldOrPropertyWithValue("categoryName", "Category1");
        assertThat(category).hasFieldOrPropertyWithValue("categoryDescription", "Decription1");
    }

    @Test
    void should_find_all_category() {
        Category category1 = new Category();
        category1.setCategoryName("Categor1");
        category1.setCategoryDescription("Decripcion1");
        testEntityManager.persist(category1);

        Category category2 = new Category();
        category2.setCategoryName("Categor2");
        category2.setCategoryDescription("Decripcion2");
        testEntityManager.persist(category2);

        Category category3 = new Category();
        category3.setCategoryName("Categor3");
        category3.setCategoryDescription("Decripcion3");
        testEntityManager.persist(category3);

        List<Category> categories = categoryRepository.findAll();

        assertThat(categories).hasSize(3).contains(category1, category1, category3);
    }

    @Test
    void should_find_tutorial_by_id() {
        Category category1 = new Category();
        category1.setCategoryName("Ropa1");
        category1.setCategoryDescription("Categoria de ropa");
        Category category = categoryRepository.save(category1);

        Category category2 = categoryRepository.findById(category.getCategoryId()).get();

        assertThat(category2).isEqualTo(category1);
    }

    @Test
    void should_delete_all_categories() {
        categoryRepository.deleteAll();

        assertThat(categoryRepository.findAll()).isEmpty();
    }

}
