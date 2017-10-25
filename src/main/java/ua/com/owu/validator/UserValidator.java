package ua.com.owu.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.owu.entity.User;
import ua.com.owu.service.UserService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator{
    @Autowired
    UserService userService;
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    private Pattern pattern;
    private Matcher matcher;

    String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    String NAME_PATTERN="[a-zA-Z]+";
    String PASSWORD_PATTERN="[a-zA-Z0-9]+";

    @Override
    public void validate(Object target, Errors errors) {
        User user=(User)target;
        ValidationUtils.rejectIfEmpty(errors,"username","required.name","enter the name");
        if (!(user.getUsername()!=null&&user.getUsername().isEmpty())){
            pattern=Pattern.compile(NAME_PATTERN);
            matcher=pattern.matcher(user.getUsername());
            if (!matcher.matches()){
                errors.rejectValue("username","name.containNonChar","enter a valid username");
            }
        }
        if (userService.findByName(user.getUsername())!=null){
            errors.rejectValue("username","error","name already exist");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","required.email","Email is required");

        if (!(user.getEmail()!=null&&user.getEmail().isEmpty())){
            pattern=Pattern.compile(EMAIL_PATTERN);
            matcher=pattern.matcher(user.getEmail());
            if (!matcher.matches()){
                errors.rejectValue("email","email.incorrect","Enter a valid email");
            }
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","required.password","password is required");
        if (!(user.getPassword()!=null&&user.getPassword().isEmpty())){
            pattern=Pattern.compile(PASSWORD_PATTERN);
            matcher=pattern.matcher(user.getPassword());
            if (!matcher.matches()){
                errors.rejectValue("password","password.incorrect","invalid password");
            }
        }

    }
}
