package com.itlife.shop.controller;

import com.itlife.shop.common.api.CommonPage;
import com.itlife.shop.common.api.CommonResult;
import com.itlife.shop.mbg.model.PmsBrand;
import com.itlife.shop.service.PmsBrandService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: itlife
 * @description: 品牌管理Controller
 * @author: He.Jian-hj
 * @create: 2021-05-26 00:20
 **/
@Controller
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;

    private  static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);
    /**
     * @Description //TODO 
     * @Date 11:18 下午 2021/5/27
     * @Param []
     * @return com.itlife.shop.common.api.CommonResult<java.util.List<com.itlife.shop.mbg.model.PmsBrand>>
     **/
    @ApiOperation("获取所有品牌列表")
    @RequestMapping(value = "listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(pmsBrandService.listAllBrand());
    }
    /**
     * @Description //TODO 
     * @Date 11:15 下午 2021/5/27
     * @Param [pmsBrand]
     * @return com.itlife.shop.common.api.CommonResult
     **/
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("添加品牌")
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand) {
        CommonResult commonResult;
        int count = pmsBrandService.createBrand(pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("createBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }
    /**
     * @Description //TODO 
     * @Date 11:14 下午 2021/5/27
     * @Param [id, pmsBrandDto, result]
     * @return com.itlife.shop.common.api.CommonResult
     **/
    @ApiOperation("更新指定id品牌信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result) {
        CommonResult commonResult;
        int count = pmsBrandService.updateBrand(id, pmsBrandDto);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrandDto);
            LOGGER.debug("updateBrand success:{}", pmsBrandDto);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.error("updateBrand failed:{}", pmsBrandDto);
        }
        return commonResult;
    }
    /**
     * @Description //TODO 
     * @Date 11:14 下午 2021/5/27
     * @Param [id]
     * @return com.itlife.shop.common.api.CommonResult
     **/
    @ApiOperation("删除指定id的品牌")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        int count = pmsBrandService.deleteBrand(id);
        if (count == 1) {
            LOGGER.debug("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }
    /**
     * @Description //TODO 
     * @Date 11:14 下午 2021/5/27
     * @Param [pageNum, pageSize]
     * @return com.itlife.shop.common.api.CommonResult<CommonPage<PmsBrand>>
     **/
    @ApiOperation("分页查询品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1")
                                                            @ApiParam("页码")Integer pageNum,
                                                                   @RequestParam(value = "pageSize", defaultValue = "3")
                                                                   @ApiParam("每页数量")Integer pageSize) {
        List<PmsBrand> brandList = pmsBrandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }
    
    /**
     * @Description //TODO 
     * @Date 11:14 下午 2021/5/27
     * @Param [id]
     * @return com.itlife.shop.common.api.CommonResult<com.itlife.shop.mbg.model.PmsBrand>
     **/
    @ApiOperation("获取指定id的品牌详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        return CommonResult.success(pmsBrandService.getBrand(id));
    }
}
