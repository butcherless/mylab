package com.mylab.learn.shopping.domain;

import java.util.ArrayList;
import java.util.List;

public class User extends AbstractEntity {
    private List<Path> paths = new ArrayList<Path>();

    public User() {
    }
}
