package com.jitesh.library_api.validation;

import org.springframework.stereotype.Component;

@Component
public class PaginationValidator {

    private static final int MAX_PAGE_SIZE = 50;

    public void validate(int page, int size, String sortBy, String direction) {

        if (page < 0) {
            throw new IllegalArgumentException(
                    "Page number cannot be negative"
            );
        }

        if (size < 1 || size > MAX_PAGE_SIZE) {
            throw new IllegalArgumentException(
                    "Page size must be between 1 and " + MAX_PAGE_SIZE
            );
        }

        if (!isValidSortField(sortBy)) {
            throw new IllegalArgumentException(
                    "Invalid sort field: " + sortBy
            );
        }

        if (!direction.equalsIgnoreCase("asc")
                && !direction.equalsIgnoreCase("desc")) {

            throw new IllegalArgumentException(
                    "Direction must be 'asc' or 'desc'"
            );
        }
    }

    private boolean isValidSortField(String sortBy) {

        return sortBy.equals("id")
                || sortBy.equals("title")
                || sortBy.equals("author")
                || sortBy.equals("price");
    }
}