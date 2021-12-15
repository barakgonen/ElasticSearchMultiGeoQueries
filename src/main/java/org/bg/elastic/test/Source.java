package org.bg.elastic.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Source {
    private final Set indices;
    private final Set types;
    private final Set ids;

    public Source(String source) {
        String[] parts = source.split("/");

        indices = parts[0].equals("*") ? null : new HashSet<>(Arrays.asList(parts[0].split(",")));

        if (parts.length > 1) {
            types = parts[1].equals("*") ? null : new HashSet<>(Arrays.asList(parts[1].split(",")));
        } else {
            types = null;
        }

        if (parts.length > 2) {
            ids = parts[2].equals("*") ? null : new HashSet<>(Arrays.asList(parts[2].split(",")));
        } else {
            ids = null;
        }

    }

    public Set getIds() {
        return ids;
    }

    public Set getIndices() {
        return indices;
    }

    public Set getTypes() {
        return types;
    }

}
