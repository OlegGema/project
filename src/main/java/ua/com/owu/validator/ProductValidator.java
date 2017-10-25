package ua.com.owu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.owu.entity.Product;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class ProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    private Pattern pattern;
    private Matcher matcher;

    String PRODUCT_PATTERN="[a-zA-Z0-9]+";
    String PRODCUT_PRICE_PATTERN="[0-9]+";

    @Override
    public void validate(Object target, Errors errors) {
        Product product=(Product)target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"productName","productName.empty","enter product name");
        if (!(product.getProductName()!=null&&product.getProductName().isEmpty())){
            pattern=Pattern.compile(PRODUCT_PATTERN);
            matcher=pattern.matcher(product.getProductName());
            if(!matcher.matches()){
                errors.rejectValue("productName","productName.empty","enter valid product name");
            }
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"productDescription","productDescription.empty","enter product Description");
        if (!(product.getProductDescription()!=null&&product.getProductDescription().isEmpty())){
            pattern=Pattern.compile(PRODUCT_PATTERN);
            matcher=pattern.matcher(product.getProductDescription());
            if(!matcher.matches()){
                errors.rejectValue("productDescription","productDescription.empty","enter valid product Description");
            }
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"productPrice","productPrice.empty","enter product price");
        if (!(product.getProductPrice()!=0)){
            pattern=Pattern.compile(PRODCUT_PRICE_PATTERN);
            matcher=pattern.matcher(product.getProductDescription());
            if(!matcher.matches()){
                errors.rejectValue("productPrice","productprice.empty","enter valid product price");
            }
        }




    }
}
