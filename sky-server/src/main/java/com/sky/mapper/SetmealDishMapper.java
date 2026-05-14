package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    /**
     *根据菜品id查询对应的套餐id
     * @param dishIds
     * @return
     */

    List<Long> getSetmaelIdsByDishIds(List<Long> dishIds);

    /**
     * 新增套餐
     * @param setmealDishList
     */
    void insertBatch(List<SetmealDish> setmealDishList);

    /**
     * 批量删除关联菜品
     * @param ids
     */
    void deleteBySetmealIds(List<Long> ids);

    /**
     * 查套餐关联的菜品
     * @param id
     * @return
     */
    List<SetmealDish> getBySetmealId(Long id);


}
