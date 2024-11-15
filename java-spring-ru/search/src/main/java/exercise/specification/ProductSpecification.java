package exercise.specification;

import exercise.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

// BEGIN
@Component
public class ProductSpecification {

    @Autowired
    private CategoryRepository categoryRepository;

    public Specification<Product> build(ProductParamsDTO params) {
        return withTitleCont(params.getTitleCont())
                .and(withCategoryId(params.getCategoryId()))
                .and(withPriceLt(params.getPriceLt()))
                .and(withPriceGt(params.getPriceGt()))
                .and(withRatingGt(params.getRatingGt()));
    }

    private Specification<Product> withTitleCont(String titleCont) {
        return (root, query, criteriaBuilder) -> titleCont == null ?
                criteriaBuilder.conjunction() :
                criteriaBuilder.like(root.get("title"), "%" + titleCont + "%");
    }

    private Specification<Product> withCategoryId(Long categotyId) {
        return (root, query, criteriaBuilder) -> categotyId == null ?
                criteriaBuilder.conjunction() :
                criteriaBuilder.equal(root.get("category").get("id"), categotyId);
    }

    private Specification<Product> withPriceLt(Integer priceLt) {
        return (root, query, criteriaBuilder) -> priceLt == null ?
                criteriaBuilder.conjunction() :
                criteriaBuilder.lessThan(root.get("price"), priceLt);
    }

    private Specification<Product> withPriceGt(Integer priceGt) {
        return (root, query, criteriaBuilder) -> priceGt == null ?
                criteriaBuilder.conjunction() :
                criteriaBuilder.greaterThan(root.get("price"), priceGt);
    }

    private Specification<Product> withRatingGt(Double ratingGt) {
        return (root, query, criteriaBuilder) -> ratingGt == null ?
                criteriaBuilder.conjunction() :
                criteriaBuilder.greaterThan(root.get("rating"), ratingGt);
    }
}
// END
