package com.example.productcatalogservice.services;

import com.example.productcatalogservice.dtos.SortParam;
import com.example.productcatalogservice.dtos.SortType;
import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService implements ISearchService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Page<Product> searchProducts(String query, Integer pageNumber, Integer pageSize, List<SortParam> sortParams) {
//        Sort sort = Sort.by("amount").descending().and(Sort.by("id").descending());
        Sort sort = null;
        if(!sortParams.isEmpty()){
            if(sortParams.get(0).getSortType().equals(SortType.ASC))
                sort = Sort.by(sortParams.get(0).getAttribute());
            else
                sort = Sort.by(sortParams.get(0).getAttribute()).descending();

        for(int i=1;i<sortParams.size();i++){
            if(sortParams.get(i).getSortType().equals(SortType.ASC))
                sort = sort.and(Sort.by("amount").descending().and(Sort.by("id").descending()));
            else
                sort = sort.and(Sort.by(sortParams.get(i).getAttribute()).descending());
        }

        }

        return productRepo.findProductByTitleEquals(query, PageRequest.of(pageNumber,pageSize,sort));
    }
}
