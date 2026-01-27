package com.tabadegacontrol.application.port.input;

import com.tabadegacontrol.application.dto.ProductRequest;
import com.tabadegacontrol.domain.model.Product;

public interface ProductUseCase {

    Product processProduct ( ProductRequest productRequest);

}
