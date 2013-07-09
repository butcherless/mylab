package com.mylab.learn.myarchetype.domain;

import java.util.List;

public class DomainUtils {
    public static Boolean hasUniqueResult(final List<? extends AbstractEntity> entities) {
        return entities.size() == 1;
    }
}
