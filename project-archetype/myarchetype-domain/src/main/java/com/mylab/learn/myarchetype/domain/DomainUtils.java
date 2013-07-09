package com.mylab.learn.myarchetype.domain;

import java.util.List;

public class DomainUtils {
    public static Boolean hasUniqueResult(final List<? extends AbstractEntity> entities) {
        return entities.size() == 1;
    }

    public static Boolean isObject(final Object object) {
        return object != null;
    }

    public static Boolean isEntity(final AbstractEntity entity) {
        Boolean result = Boolean.TRUE;
        if ((entity == null) || (entity.getId() == null)) {
            result = Boolean.FALSE;
        }

        return result;
    }
}
