package com.example.faceittest.service;

import java.util.List;
import org.springframework.data.domain.Sort;

public interface SortService {
    List<Sort.Order> parse(String sortBy);
}
