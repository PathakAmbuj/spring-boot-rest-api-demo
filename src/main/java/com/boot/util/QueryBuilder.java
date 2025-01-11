package com.boot.util;

import com.boot.entity.user.User;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class QueryBuilder {

    public String build(User user) {
        StringBuilder query = new StringBuilder();

        query.append("SELECT * FROM USERS WHERE ");

        String stringFormatter = " = '%s' ";
        String isNullString = " is null ";
        query.append("firstname").append(String.format(stringFormatter, user.getFirstName()));
        query.append("and lastname").append(String.format(stringFormatter, user.getLastName()));

        if(!Objects.equals(user.getAddress(), "default-value"))
            query.append("and address").append(user.getAddress() == null ? isNullString : String.format(stringFormatter, user.getAddress()));

        /*if(!address.equals("default-value") && user.getAddress() != null)
            query.append("and address = '").append(address).append("' ");
        else if (address.equals("null"))
            query.append("and address is ").append(address).append(" ");
*/
        return query.toString();
    }
}
