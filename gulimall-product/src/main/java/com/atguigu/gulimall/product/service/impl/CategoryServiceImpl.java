package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //1.查询所有的商品种类
        List<CategoryEntity> entityList = baseMapper.selectList(null);

        //2.组装父子的树形
        //  2.1结构选出所有parent_cid为0的一级种类
        List<CategoryEntity> level1Menus = entityList.stream().
                filter(categoryEntity -> categoryEntity.getParentCid() == 0).
                map((categoryEntity) -> {
                    //查询子分类
                    categoryEntity.setChildren(getChildren(categoryEntity, entityList));
                    return categoryEntity;
                }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());

        return level1Menus;
    }

    @Override
    public void deleteMenuByIds(List<Long> catIds) {
        //TODO 1.检查当前删除的菜单，是否有被别的地方引用
        baseMapper.deleteBatchIds(catIds);
    }


    /**
     * 递归查询子种类
     *
     * @param categoryEntity
     * @param entityList
     * @return
     */
    private List<CategoryEntity> getChildren(CategoryEntity categoryEntity, List<CategoryEntity> entityList) {
        List<CategoryEntity> childrenCategory = entityList.stream().filter((childrenCategoryEntity) -> childrenCategoryEntity.getParentCid() == categoryEntity.getCatId()).
                map(childrenCategoryEntity -> {
                    childrenCategoryEntity.setChildren(getChildren(childrenCategoryEntity, entityList));
                    return childrenCategoryEntity;
                }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());
        return childrenCategory;
    }

}