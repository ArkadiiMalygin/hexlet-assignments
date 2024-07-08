package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        var notValid = new ArrayList<String>();
        var parameters = address.getClass().getDeclaredFields();
        for (Field field : parameters) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (Objects.isNull(field.get(address))) {
                        notValid.add(field.getName());
                    };
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return notValid;
    }
}
// END
