package com.luanvo.busa.service.imp;

import com.luanvo.busa.io.entity.ProductEntity;
import com.luanvo.busa.io.response.GetListProductResponse;
import com.luanvo.busa.io.resquest.GetAllProductRequest;
import com.luanvo.busa.io.values.Configuration;
import com.luanvo.busa.repository.ProductRepository;
import com.luanvo.busa.service.ProductService;
import com.luanvo.busa.utils.ErrorContent;
import com.luanvo.busa.utils.Response;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

    @Value("${luanvo.page_limit}")
    private int pageLimit;

    @Autowired
    ProductRepository productRepository;

    @Override
    public JSONObject getList(GetAllProductRequest request) {
        try {

            Pageable pageable = PageRequest.of(request.getPage(), pageLimit);
            Page<ProductEntity> dataDB = productRepository.findByFilter(request.getSearch(),request.getPrice_min(),request.getPrice_max(),request.getCity_id(),pageable);
            List<GetListProductResponse> data = dataDB.getContent().stream().map(GetListProductResponse::new).collect(Collectors.toList());

            JSONObject response = new JSONObject();
            response.put(Response.DATA,data);
            response.put(Response.TOTAL,dataDB.getTotalElements());
            return Response.success(response);
        }catch (Exception e){
            e.printStackTrace();
            return Response.error(ErrorContent.ERROR.getMsg());
        }
    }
}
