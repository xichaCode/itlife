package com.itlife.shop.service;

import com.itlife.shop.mbg.model.PmsBrand;

import java.util.List;

/**
 * @program: itlife
 * @description:
 * @author: He.Jian-hj
 * @create: 2021-05-25 00:10
 **/

public interface PmsBrandService {
    List<PmsBrand> listAllBrand();
    int createBrand(PmsBrand brand);
    int updateBrand(Long id,PmsBrand brand);
    int deleteBrand(Long id);
    List<PmsBrand> listBrand(int pageNum,int pageSize);
    PmsBrand getBrand(Long id);

}
